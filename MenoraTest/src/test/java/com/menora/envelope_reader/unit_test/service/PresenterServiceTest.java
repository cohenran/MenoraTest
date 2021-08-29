package com.menora.envelope_reader.unit_test.service;

import com.menora.envelope_reader.component_test.converter.GeneralXMLConverter;
import com.menora.envelope_reader.controller.PresenterController;
import com.menora.envelope_reader.dal.RequestRepository;
import com.menora.envelope_reader.model.db.RequestEntity;
import com.menora.envelope_reader.model.general.XML;
import com.menora.envelope_reader.model.xml.EventEntity;
import com.menora.envelope_reader.model.xml.ProductEntity;
import com.menora.envelope_reader.model.xml.RequestDetailsEntity;
import com.menora.envelope_reader.model.xml.RootEntity;
import com.menora.envelope_reader.services.PresentService;
import com.menora.envelope_reader.services.impl.PresentServiceImpl;
import com.menora.envelope_reader.services.impl.ResourceReaderServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PresenterServiceTest {	
	@Mock
	private GeneralXMLConverter generalXMLConverter;

	@Mock
	private RequestRepository requestRepository;

	@InjectMocks
	PresentService presentService = new PresentServiceImpl();
	
	@Test
	public void productsByInsuredIdBySourceCompany() throws Exception {
		RequestEntity testRequestEntity = new RequestEntity(null, null);
		List<RequestEntity> requestEntities = new ArrayList<>();
		requestEntities.add(testRequestEntity);
		
		when(requestRepository.findAll()).thenReturn(requestEntities);
		when(generalXMLConverter.getRootEntity(new XML())).thenReturn(new RootEntity(new RequestDetailsEntity(), 
				new EventEntity[]{new EventEntity(null, null, null, new ProductEntity[] {
						new ProductEntity(null, null, null, null)})}));

		assertEquals(presentService.productsByInsuredIdBySourceCompany().get(null).get(null),
				Collections.singletonList(new ProductEntity(null, null, null, null)));
	}
}