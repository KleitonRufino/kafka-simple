package com.example.springboot_kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final Producer producer;

	@Autowired
	KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish", consumes = "application/json")
	public void sendMessageToKafkaTopic(@RequestBody Message message) {
		this.producer.sendMessage(message.getMessage());
	}
}