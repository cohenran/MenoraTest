package com.menora.envelope_reader.component_test.services;


import com.menora.envelope_reader.Application;
import com.menora.envelope_reader.services.ResourceReaderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ResourceReaderServiceTest {
	@Autowired
	private ResourceReaderService resourceReaderService;

	@Test
	public void readResourceTest() {
		String xml = resourceReaderService.resourceFileReader("Request.xml");

		assertTrue(xml.length() > 0);
	}
}
