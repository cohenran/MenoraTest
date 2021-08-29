package com.menora.envelope_reader.component_test.converter;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.menora.envelope_reader.model.general.XML;
import com.menora.envelope_reader.model.xml.RootEntity;
import com.menora.envelope_reader.services.impl.ResourceReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeneralXMLConverter {
	@Autowired
	private ResourceReaderServiceImpl resourceReaderService;

	public RootEntity getRootEntity(String fileName) throws IOException {
		XML xml = new XML(resourceReaderService.resourceFileReader(fileName));

		return getRootEntity(xml);
	}

	public RootEntity getRootEntity(XML xml) throws IOException {
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);

		return xmlMapper.readValue(xml.getContent(), RootEntity.class);
	}
}
