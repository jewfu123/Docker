package com.fu.examples.testSpringAmqp2.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitListener {
//	@RabbitListener(queues="foo47")
//	public void listenSimpleQueueMessage(String msg) throws InterruptedException {
//		System.out.println("spring 消费者接收到的消息：[[ " + msg + " ]]");
//	}
	
	
	@RabbitListener(queues="foo")
	public void listenWorkQueue1(String msg) throws InterruptedException {
		System.out.println("spring 消费者1接收到的消息：[[ " + msg + " ]]");
		Thread.sleep(20);
	}
	
	@RabbitListener(queues="foo")
	public void listenWorkQueue2(String msg) throws InterruptedException {
		System.out.println("spring 消费者2接收到的消息：[[ " + msg + " ]]");
		Thread.sleep(200);
	}
	
	@RabbitListener(queues="fanout.queue1")
	public void listenFanoutQueue1(String msg) throws InterruptedException {
		System.out.println("spring 消费者接收到 fanout.queue1 的消息：[[ " + msg + " ]]");
	}
	
	@RabbitListener(queues="fanout.queue2")
	public void listenFanoutQueue2(String msg) throws InterruptedException {
		System.out.println("spring 消费者接收到 fanout.queue2 的消息：[[ " + msg + " ]]");
	}
}
