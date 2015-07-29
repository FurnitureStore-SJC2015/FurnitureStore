package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.User;
import com.exposit.repository.dao.UserDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class UserRepository extends AbstractHibernateDao<User, Integer>
		implements UserDao {

}
