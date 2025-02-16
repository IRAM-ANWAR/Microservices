package com.learning.payment.service;

import com.learning.payment.model.PaymentRequest;
import com.learning.payment.model.PaymentResponse;

public interface PaymentService {
	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetailsByOrderId(String orderId);
}