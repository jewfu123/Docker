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

package com.fu.testSpringAmqp.amqp;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@PostConstruct
	public void setUpQueue() {
		this.amqpAdmin.declareQueue(new Queue("foo464"));
	}

	@Scheduled(fixedDelay = 1000L)
	public void send() {
		//this.rabbitTemplate.convertAndSend("foo47", "hello xsb dsb!!!   ------------------->>");
		for (int i=1; i<=10; i++) {
			this.rabbitTemplate.convertAndSend("foo464", "hello xsb dsb!!! --- " + i);
		}
		testSendFanoutExchange();
	}
	
	// 发送消息给交换机
	@Scheduled(fixedDelay = 1000L)
	public void testSendFanoutExchange() {
		// 交换机名称
		String exchangeName = "amq.fanout";
		// message
		String message = "hello, xdszi!!!";
		// send message
		this.rabbitTemplate.convertAndSend(exchangeName, "", message);
		
	}

}
