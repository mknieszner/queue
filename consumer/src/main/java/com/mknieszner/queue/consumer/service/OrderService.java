package com.mknieszner.queue.consumer.service;

import com.mknieszner.queue.model.Product;

public interface OrderService {

	void processOrder(Product product);
}
