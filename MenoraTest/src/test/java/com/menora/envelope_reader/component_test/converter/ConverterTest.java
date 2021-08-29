package com.menora.envelope_reader.component_test.converter;


import com.menora.envelope_reader.Application;
import com.menora.envelope_reader.model.xml.RootEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ConverterTest {
	@Value("${consts.xml_location}")
	private String xmlLocation;
	
	@Autowired
	private GeneralXMLConverter generalXMLConverter;
	
	@Test
	public void converterTest() throws Exception {
		RootEntity rootEntity = generalXMLConverter.getRootEntity(xmlLocation);

		assertEquals(rootEntity.getEvents().length, 3);
		assertEquals(rootEntity.getEvents()[0].getId(), "471b29e7-a323-447b-88d8-935737e9ffd4");
	}
}
