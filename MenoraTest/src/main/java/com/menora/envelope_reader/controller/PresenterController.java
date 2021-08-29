package com.menora.envelope_reader.controller;


import com.menora.envelope_reader.model.xml.ProductEntity;
import com.menora.envelope_reader.services.PresentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/present")
public class PresenterController {
	@Autowired
	private PresentService presentService;

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Map<Long, List<ProductEntity>>> productsByInsuredIdBySourceCompany() throws Exception {
		return presentService.productsByInsuredIdBySourceCompany();
	}
}
