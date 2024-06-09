package com.fu.examples.testSpringAmqp2.amqp.config;

import java.util.Map;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
	@RabbitListener(bindings=@QueueBinding(
			value=@Queue(name="topic.queue1"),
			exchange=@Exchange(name="itcast.topic", type=ExchangeTypes.TOPIC),
			key={"china.#"}
			))
	public void listenTopicQueue1(String msg) {
		System.out.println("消费者1接收到Topic消息:[" + msg + "]");
	}
	
	@RabbitListener(bindings=@QueueBinding(
			value=@Queue(name="topic.queue2"),
			exchange=@Exchange(name="itcast.topic", type=ExchangeTypes.TOPIC),
			key={"#.news"}
			))
	public void listenTopicQueue2(String msg) {
		System.out.println("消费者2接收到Topic消息:[" + msg + "]");
	}
	
	@RabbitListener(queues="itcast.object")
	public void listenObjectQueue(Map<String, Object>msg) {
		System.out.println("接收到 object.queue 的消息:  " + msg + " ");
	}
}
