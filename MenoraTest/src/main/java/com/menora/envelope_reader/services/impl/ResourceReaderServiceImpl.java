package com.menora.envelope_reader.services.impl;

import com.menora.envelope_reader.services.ResourceReaderService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class ResourceReaderServiceImpl implements ResourceReaderService {
	@Override
	public String resourceFileReader(String filePath) throws FileNotFoundException {
		StringBuilder resourceFile = new StringBuilder();
		InputStream is = new FileInputStream(filePath);

		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				resourceFile.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return resourceFile.toString();
	}
}
