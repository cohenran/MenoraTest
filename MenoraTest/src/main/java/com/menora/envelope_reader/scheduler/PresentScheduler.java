package com.menora.envelope_reader.scheduler;

import com.menora.envelope_reader.component_test.converter.GeneralXMLConverter;
import com.menora.envelope_reader.dal.RequestRepository;
import com.menora.envelope_reader.model.db.RequestEntity;
import com.menora.envelope_reader.model.xml.RootEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
public class PresentScheduler {
	@Value("${consts.xml_location}")
	private String xmlLocation;

	@Autowired
	private GeneralXMLConverter generalXMLConverter;

	@Resource
	private RequestRepository requestRepository;

	@Scheduled(fixedDelayString = "${consts.inspect_duration}")
	private void process() throws IOException {
		File xmlDirectory = new File(xmlLocation);

		// The directory might not exist
		if (xmlDirectory.exists()) {
			File[] files = xmlDirectory.listFiles();

			if (files != null && files.length > 0) {
				for (File curr : files) {
					String content = new String(Files.readAllBytes(Paths.get(xmlLocation + "\\" + curr.getName())));
					RootEntity rootEntity = generalXMLConverter.getRootEntity(curr.getAbsolutePath());

					// Save in the DB with the given ID
					String id = rootEntity.getRequestDetails().getId();

					RequestEntity requestEntity = new RequestEntity(id, content);
					requestRepository.save(requestEntity);
				}
			} else {
				log.warn("No files found or IO-error occurred");
			}
		} else {
			log.warn("Directory doesn't exists!");
		}
	}
}
