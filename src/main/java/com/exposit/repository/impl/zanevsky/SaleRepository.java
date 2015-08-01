package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.zanevsky.SaleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class SaleRepository extends AbstractHibernateDao<Sale, Integer>
		implements SaleDao {

}
