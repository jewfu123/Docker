package com.fu.examples.testSpringAmqp2.amqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SampleAmqpSimpleApplication.class)
public class SampleAmqpSimpleTests {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private AmqpAdmin amqpAdmin;

	@Test
	public void test() {
		System.out.print("hello xsb.");
	}
	
	@Test
	public void testSimpleQueue() {
		String queueName = "foo464";
		String message = "hello, you are xsb.";
		rabbitTemplate.convertAndSend(queueName, message);
	}
	
	@Test
	public void testNewQueue() {
		String queueName = "fooXsb";
		String message = "hello, you are dsb.";
		this.amqpAdmin.declareQueue(new Queue(queueName));
		rabbitTemplate.convertAndSend(queueName, message);
	}
	
	@Test
	public void send2Fanout() throws InterruptedException {
		String exchangeName = "itcast.fanout";
		String message = "hello every one!";
		for (int i=0;i<50;i++) {
			rabbitTemplate.convertAndSend(exchangeName, "", message + i);
		}
	}
}
