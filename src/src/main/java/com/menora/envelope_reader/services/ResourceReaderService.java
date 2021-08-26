package com.menora.envelope_reader.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class ResourceReaderService {
	public String resourceFileReader(String fileName) {
		String resourceFile = "";
		InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

		try (InputStreamReader streamReader =
					 new InputStreamReader(is, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				resourceFile += line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resourceFile;
	}
}
