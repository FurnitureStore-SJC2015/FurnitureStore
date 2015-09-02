package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Client;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;
import com.exposit.repository.base.GenericDao;

public interface PaymentDao extends GenericDao<Payment, Integer> {

	public List<Payment> getListOfAllPayments(Order order);

	public List<Payment> getFuturePayments(Client client);
}
