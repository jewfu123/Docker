package com.fu.examples.testSpringAmqp2.amqp.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
	@RabbitListener(bindings=@QueueBinding(
			value=@Queue(name="direct.queue1"),
			exchange=@Exchange(name="itcast.direct", type=ExchangeTypes.DIRECT),
			key={"red", "blue"}
			))
	public void listenDirectQueue1(String msg) {
		System.out.println("消费者1接收到Direct消息:[" + msg + "]");
	}
	
	@RabbitListener(bindings=@QueueBinding(
			value=@Queue(name="direct.queue2"),
			exchange=@Exchange(name="itcast.direct", type=ExchangeTypes.DIRECT),
			key={"red", "yellow"}
			))
	public void listenDirectQueue2(String msg) {
		System.out.println("消费者2接收到Direct消息:[" + msg + "]");
	}
}
