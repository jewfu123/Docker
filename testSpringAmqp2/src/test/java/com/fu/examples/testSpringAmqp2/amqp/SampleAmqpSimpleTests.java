package com.fu.examples.testSpringAmqp2.amqp;

import java.util.HashMap;
import java.util.Map;

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
	
	@Test
	public void send2Direct() throws InterruptedException {
		String exchangeName = "itcast.direct";
		String message = "hello direct every one!";
		for (int i=0;i<100;i++) {
			rabbitTemplate.convertAndSend(exchangeName, "blue", message + i);
		}
	}
	
	@Test
	public void send2Topic() throws InterruptedException {
		String exchangeName = "itcast.topic";
		String message = "hello topic every one!";
		for (int i=0;i<100;i++) {
			rabbitTemplate.convertAndSend(exchangeName, "china.weath", message + i);
		}
	}
	
	@Test
	public void send2Object() throws InterruptedException {
		Map<String, Object> msg = new HashMap<>();
		msg.put("name",  "大姐");
		msg.put("age", "23");
		String queueName = "object.queue";
		for (int i=0;i<10;i++) {
			rabbitTemplate.convertAndSend(queueName, msg);
		}
	}
}
