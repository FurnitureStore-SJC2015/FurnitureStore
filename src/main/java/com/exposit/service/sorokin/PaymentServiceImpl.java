package com.exposit.service.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.repository.dao.sorokin.PaymentDao;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentRepository;

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

}
