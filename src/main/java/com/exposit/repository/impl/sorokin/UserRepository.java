package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.dao.sorokin.UserDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class UserRepository extends AbstractHibernateDao<User, Integer>
		implements UserDao {

}
