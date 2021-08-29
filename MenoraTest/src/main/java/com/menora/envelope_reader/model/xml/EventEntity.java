package com.menora.envelope_reader.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
	@JsonProperty("Id")
	private String id;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("InsuredId")
	private Long insuredId;
	@JsonProperty("Product")
	private ProductEntity[] productEntity;
}
