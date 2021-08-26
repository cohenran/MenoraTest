package com.menora.envelope_reader.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
	@JsonProperty("Id")
	private String id;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("InsuredId")
	private long insuredId;
	@JsonProperty("Product")
	private ProductEntity[] productEntity;
}
