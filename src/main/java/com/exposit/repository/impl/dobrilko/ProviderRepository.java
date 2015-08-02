package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProviderRepository extends AbstractHibernateDao<Provider, Integer>
		implements ProviderDao {

}
