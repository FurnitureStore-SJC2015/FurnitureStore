package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Bonus;
import com.exposit.domain.model.Client;
import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Role;
import com.exposit.domain.model.User;
import com.exposit.repository.dao.UserDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class UserRepository extends AbstractHibernateDao<User, Integer>
		implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListOfAllUsersByRole(Role role) {
		Criteria cr = getSession().createCriteria(User.class, "user").add(
				Restrictions.eq("role", role));
		return (List<User>) cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListOfAllUsersByBonus(Bonus bonus) {
		Criteria cr = getSession().createCriteria(User.class, "user").add(
				Restrictions.eq("bonus", bonus));
		return (List<User>) cr.list();
	}

	@Override
	public User findUserByLoginAndPassword(String login, String password) {
		Criteria cr = getSession().createCriteria(User.class, "user")
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password));
		return (User) cr.uniqueResult();
	}

	@Override
	public User findUserByName(String username) {
		Criteria cr = getSession().createCriteria(User.class).add(
				Restrictions.eq("login", username));
		return (User) cr.uniqueResult();
	}

	@Override
	public List<User> queryListOfUsers(Integer size, Integer offset) {
		Criteria cr = getSession().createCriteria(User.class);
		cr.setFirstResult(size * (offset - 1));
		cr.setMaxResults(size);
		return (List<User>) cr.list();
	}

	@Override
	public List<User> getListOfUsersByRole(Role role, Integer size,
			Integer offset) {
		Criteria cr = getSession().createCriteria(User.class).add(
				Restrictions.eq("role", role));
		cr.setFirstResult(size * (offset - 1));
		cr.setMaxResults(size);
		return (List<User>) cr.list();
	}

	@Override
	public Integer getCountOfUsersByRole(Role role) {
		Criteria cr = getSession().createCriteria(User.class).add(
				Restrictions.eq("role", role));
		cr.setProjection(Projections.rowCount());
		Long result = (Long) cr.uniqueResult();
		return result.intValue();
	}

	@Override
	public User getUserByFeedback(Feedback feedback) {
		Criteria cr = getSession().createCriteria(Client.class, "client");
		cr.createAlias("client.feedbacks", "feedbacks");
		cr.add(Restrictions.eq("feedbacks.id", feedback.getId()));
		return (User) cr.uniqueResult();
	}

}
