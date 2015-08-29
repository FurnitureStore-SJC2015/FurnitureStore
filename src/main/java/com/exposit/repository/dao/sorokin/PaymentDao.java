package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.repository.base.GenericDao;

public interface PaymentDao extends GenericDao<Payment, Integer> {

	public List<Payment> getListOfAllPayments(Order order);

	public List<Payment> getFuturePayments(Client client);
}
