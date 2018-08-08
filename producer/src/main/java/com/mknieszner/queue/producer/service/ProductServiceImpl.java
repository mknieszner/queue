package com.mknieszner.queue.producer.service;

import com.mknieszner.queue.producer.messaging.MessageSender;
import com.mknieszner.queue.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	MessageSender messageSender;
	
	@Override
	public void sendProduct(Product product) {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		LOG.info("Application : sending order request {}", product);
		messageSender.sendMessage(product);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
}
