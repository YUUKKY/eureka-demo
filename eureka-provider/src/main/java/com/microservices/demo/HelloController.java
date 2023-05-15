package com.microservices.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/ok")
	public String ok() {
		return "producer1 ok";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, eureka1";
	}
}
