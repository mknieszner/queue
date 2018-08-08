package com.mknieszner.queue.consumer.messaging;

import com.mknieszner.queue.model.Product;
import com.mknieszner.queue.consumer.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageReceiver implements MessageListener{

	private static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	
	@Autowired
	MessageConverter messageConverter;
	
	@Autowired
	OrderService orderService;

	@Override
	public void onMessage(Message message) {
		LOG.info("message m {}", message);
		try {
			if(messageConverter.fromMessage(message) instanceof Product){
				LOG.info("-----------------------------------------------------");
				Product product = (Product) messageConverter.fromMessage(message);
				LOG.info("Application : order received : {}",product);
				orderService.processOrder(product);
				LOG.info("-----------------------------------------------------");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}

