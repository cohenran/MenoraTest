package com.menora.envelope_reader.component_test.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.menora.envelope_reader.model.xml.RootEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeneralXMLConverter {
	public RootEntity getRootEntity(String xml) throws IOException {
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);

		return xmlMapper.readValue(xml, RootEntity.class);
	}
}
