package com.menora.envelope_reader.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor()
public class RequestEntity {
	@Id
	private String requestDetailsId;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String xml;
}
