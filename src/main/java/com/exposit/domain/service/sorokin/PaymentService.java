package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;

public interface PaymentService {

	public void createNewPayment(Payment payment);

	public void deletePayment(Payment payment);
	
	public void deletePayment(int id);

	public Payment getPaymentById(int id);

	public void updatePayment(Payment payment);

	public List<Payment> getPayments(Order order);
}
