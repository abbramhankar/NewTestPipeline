package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/api/hello")
	public String returnHelloWorld() {
		LOGGER.info("Received request for /api/hello");
		LOGGER.info("Returning response for /api/hello");
		return "Hello World";
	}
}
