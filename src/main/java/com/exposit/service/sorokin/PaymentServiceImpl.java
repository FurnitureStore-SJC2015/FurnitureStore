package com.exposit.service.sorokin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.domain.service.sorokin.ShoppingCartService;
import com.exposit.repository.dao.sorokin.PaymentDao;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentRepository;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Override
	public void createNewPayment(Payment payment) {
		paymentRepository.save(payment);

	}

	@Override
	public void deletePayment(Payment payment) {
		paymentRepository.delete(payment);

	}

	@Override
	public Payment getPaymentById(int id) {
		return paymentRepository.findById(id);
	}

	@Override
	public void updatePayment(Payment payment) {
		paymentRepository.update(payment);

	}

	@Override
	public List<Payment> getPayments(Order order) {
		return paymentRepository.getListOfAllPayments(order);
	}

	@Override
	public void deletePayment(int id) {
		paymentRepository.delete(id);

	}

	@Override
	public List<Payment> calculatePayments(PaymentScheme paymentScheme) {
		List<Payment> payments = new ArrayList<Payment>();
		int delta = paymentScheme.getTerm()/ paymentScheme.getNumberOfPayments();
		DateTime paymentDate=new DateTime().plusDays(delta);
		double onePayment=shoppingCartService.getShoppingCart().getTotalPrice()/paymentScheme.getNumberOfPayments();
		for (int i = 0; i < paymentScheme.getNumberOfPayments(); i++) {
			Payment payment = new Payment();
			payment.setPaymentStatus(false);
			payment.setDate(paymentDate.toDate());
			payment.setSum(onePayment);
			paymentDate=paymentDate.plusDays(delta);
			payments.add(payment);
		}
		return payments;
	}
}
