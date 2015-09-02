package com.exposit.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Company;
import com.exposit.repository.dao.CompanyDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository
public class CompanyRepository extends AbstractHibernateDao<Company, Integer> implements CompanyDao {

	@Override
	public Company getCompanyEmployer() {
		List<Company> list = this.findAll();
		return list.get(0);
	}
	
}
