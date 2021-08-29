package com.menora.envelope_reader.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity {
	@JsonProperty("RequestDetails")
	private RequestDetailsEntity requestDetails;
	@JsonProperty("Event")
	private EventEntity[] events;
}
