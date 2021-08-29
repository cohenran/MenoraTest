package com.menora.envelope_reader.services.impl;

import com.menora.envelope_reader.component_test.converter.GeneralXMLConverter;
import com.menora.envelope_reader.dal.RequestRepository;
import com.menora.envelope_reader.model.db.RequestEntity;
import com.menora.envelope_reader.model.general.XML;
import com.menora.envelope_reader.model.xml.EventEntity;
import com.menora.envelope_reader.model.xml.ProductEntity;
import com.menora.envelope_reader.model.xml.RootEntity;
import com.menora.envelope_reader.services.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Service
public class PresentServiceImpl implements PresentService {
	@Autowired
	private GeneralXMLConverter generalXMLConverter;

	@Resource
	private RequestRepository requestRepository;

	@Override
	public Map<String, Map<Long, List<ProductEntity>>> productsByInsuredIdBySourceCompany() throws IOException {
		Map<String, Map<Long, List<ProductEntity>>> productsByInsuredIdBySourceCompany = new HashMap<>();

		// find all the xml's
		Iterable<RequestEntity> requestEntityIterable = requestRepository.findAll();

		List<RequestEntity> requestEntityList = new ArrayList<>();
		requestEntityIterable.forEach(requestEntityList::add);

		Map<Long, List<ProductEntity>> insurerIds = new HashMap<>();

		// go over them all
		for (RequestEntity currRootEntity : requestEntityList) {
			// convert from raw XML to an entity
			RootEntity rootEntity = generalXMLConverter.getRootEntity(new XML(currRootEntity.getXml()));

			// for each event, add the products related
			for (EventEntity currEvent : rootEntity.getEvents()) {
				Long insurerId = currEvent.getInsuredId();
				List<ProductEntity> productsPreInsurer = insurerIds.getOrDefault(insurerId, new ArrayList<>());
				productsPreInsurer.addAll(Arrays.asList(currEvent.getProductEntity()));

				insurerIds.put(insurerId, productsPreInsurer);
			}

			productsByInsuredIdBySourceCompany.put(rootEntity.getRequestDetails().getSourceCompany(), insurerIds);
		}

		return productsByInsuredIdBySourceCompany;
	}
}
