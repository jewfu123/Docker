package com.fu.examples.testSpringAmqp2.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class CreateSender {
	private String QueueName;
	
	@Autowired
	private AmqpAdmin amqpAdmin;
	
	public CreateSender(String equeueName) {
		this.QueueName = equeueName;
	}

	@PostConstruct
	public void setUpQueue() {
		this.amqpAdmin.declareQueue(new Queue(this.QueueName));
	}
}
