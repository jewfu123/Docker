/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fu.examples.testSpringAmqp2.amqp;

//import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import jakarta.annotation.PostConstruct;

public class Sender {
	
	private String QueueName;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AmqpAdmin amqpAdmin;
	
	public Sender(String equeueName) {
		this.QueueName = equeueName;
	}

	@PostConstruct
	public void setUpQueue() {
		this.amqpAdmin.declareQueue(new Queue(this.QueueName));
	}

	@Scheduled(fixedDelay = 1000L)
	public void send() {
		this.rabbitTemplate.convertAndSend(this.QueueName, "hello xsb da sa bi.");
	}

}
