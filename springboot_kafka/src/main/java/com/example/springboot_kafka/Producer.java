package com.example.springboot_kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	// private static final String TOPIC = "users";
	@Value("${topic.name.producer}")
	private String TOPIC;

	@Autowired
	private KafkaTemplate<String, String> template;

	public void sendMessage(String message) {
		logger.info(String.format("#### -> Producing message -> %s", message));
		this.template.send(TOPIC, message);
	}

}
