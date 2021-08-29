package com.menora.envelope_reader.unit_test.controller;

import com.menora.envelope_reader.controller.PresenterController;
import com.menora.envelope_reader.model.xml.ProductEntity;
import com.menora.envelope_reader.services.PresentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PresenterControllerTest {
	@Mock
	PresentService presentService;

	@InjectMocks
	PresenterController presenterController = new PresenterController();

	@Test
	public void testGettingTemperatureNoIdTest() throws Exception {
		Map<String, Map<Long, List<ProductEntity>>> testMap = new HashMap<>();
		testMap.put("test", null);
		when(presentService.productsByInsuredIdBySourceCompany()).thenReturn(testMap);

		Map<String, Map<Long, List<ProductEntity>>> productsByInsuredIdBySourceCompanyMap = presenterController.productsByInsuredIdBySourceCompany();

		assertTrue(productsByInsuredIdBySourceCompanyMap.containsKey("test"));
	}
}