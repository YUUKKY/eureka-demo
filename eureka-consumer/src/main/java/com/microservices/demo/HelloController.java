package com.microservices.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@GetMapping("/ok")
	public String ok() {
		return "consumer ok";
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hi")
	public String hi(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(restTemplate.getForObject("http://eureka-client-provider/hello", String.class));
			sb.append(": "+ LocalDateTime.now());
			sb.append("\n");
		}
		return sb.toString();
	}

}
