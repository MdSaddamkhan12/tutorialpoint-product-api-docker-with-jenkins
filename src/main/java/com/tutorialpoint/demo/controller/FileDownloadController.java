package com.tutorialpoint.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> download() throws IOException{
		
		String fileName = "F:/spring-course/tutorialpoint_demo/var/tmp/spring.png";
		
		File file = new File(fileName);
		InputStreamResource resource = new InputStreamResource( new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; fileName=\"%s\"", file.getName()));
		
		headers.add("Cache-control", "no-chache, no-store, must-revalidate");
		headers.add("Pragma", "no-chache");
		headers.add("Expires", "0");
		
		ResponseEntity<Object> responseEntity = 
				ResponseEntity.ok().headers(headers).contentLength(file.length()).
				contentType(MediaType.parseMediaType("application/txt")).body(resource);
		
		return responseEntity;
		
		
		
		
		
		
		
		
		
	}
}
