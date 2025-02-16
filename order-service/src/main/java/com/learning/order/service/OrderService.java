package com.learning.order.service;

import com.learning.order.model.OrderRequest;
import com.learning.order.model.OrderResponse;

public interface OrderService {
	OrderResponse getOrderDetails(long orderId);

	long placeOrder(OrderRequest orderRequest);
}