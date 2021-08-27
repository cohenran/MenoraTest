package com.menora.envelope_reader.services;

import com.menora.envelope_reader.model.xml.ProductEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PresentService {
	Map<String, Map<Long, List<ProductEntity>>> productsByInsuredIdBySourceCompany() throws IOException;
}
