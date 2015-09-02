package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Client;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;

public interface PaymentService {

	public void createNewPayment(Payment payment);

	public void deletePayment(Payment payment);

	public void deletePayment(int id);

	public Payment getPaymentById(int id);

	public void updatePayment(Payment payment);

	public List<Payment> getPayments(Order order);

	public List<Payment> calculatePayments(Order order);

	public Boolean canBePayed(Payment payment);

	public List<Payment> getFururePaymentNotifications(Client client);
}
