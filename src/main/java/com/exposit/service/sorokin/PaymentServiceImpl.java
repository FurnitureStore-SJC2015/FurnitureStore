package com.exposit.service.sorokin;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.service.sorokin.OrderService;
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

	@Autowired
	private OrderService orderService;

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
	public List<Payment> calculatePayments(Order order) {

		int delta = order.getPaymentScheme().getTerm()
				/ order.getPaymentScheme().getNumberOfPayments();
		Double bonusPersentage = (order.getClient().getBonus().getPercentage()) / 100;
		List<Payment> payments = new ArrayList<Payment>();
		DateTime paymentDate = new DateTime(order.getAssemblyDate())
				.plusDays(delta);
		DecimalFormat df = new DecimalFormat("0");
		String formate = df.format((1 - bonusPersentage)
				* orderService.getOrderSum(order)
				/ order.getPaymentScheme().getNumberOfPayments());
		Double onePaymentSum = 0d;
		try {
			onePaymentSum = df.parse(formate).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < order.getPaymentScheme().getNumberOfPayments(); i++) {
			Payment payment = new Payment();
			payment.setPaymentStatus(false);
			payment.setDate(paymentDate.toDate());
			payment.setSum(onePaymentSum);
			paymentDate = paymentDate.plusDays(delta);
			payments.add(payment);
		}
		return payments;
	}

	@Override
	public Boolean canBePayed(Payment payment) {
		Days difference = Days.daysBetween(new DateTime(),
				new DateTime(payment.getDate()));
		if (difference.getDays() < 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Payment> getFururePaymentNotifications() {
		return paymentRepository.getFuturePayments();
	}
}
