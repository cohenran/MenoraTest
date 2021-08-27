package com.menora.envelope_reader.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetailsEntity {
	@JsonProperty("Id")
	private String id;
	@JsonProperty("AcceptDate")
	private String acceptDate;
	@JsonProperty("SourceCompany")
	private String sourceCompany;
}
