package com.exposit.domain.service.sorokin;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.PaymentScheme;

public interface PaymentService {

	public void createNewPayment(Payment payment);

	public void deletePayment(Payment payment);

	public void deletePayment(int id);

	public Payment getPaymentById(int id);

	public void updatePayment(Payment payment);

	public List<Payment> getPayments(Order order);

	public List<Payment> calculatePayments(Order order);
}
