package com.menora.envelope_reader.services;

import java.io.FileNotFoundException;

public interface ResourceReaderService {
	String resourceFileReader(String fileName) throws FileNotFoundException;
}
