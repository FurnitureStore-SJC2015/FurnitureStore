package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Bonus;
import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Role;
import com.exposit.domain.model.User;
import com.exposit.repository.base.GenericDao;

public interface UserDao extends GenericDao<User, Integer> {

	public List<User> getListOfAllUsersByRole(Role role);

	public List<User> getListOfAllUsersByBonus(Bonus bonus);

	public User findUserByLoginAndPassword(String login, String password);

	public User findUserByName(String username);

	public List<User> queryListOfUsers(Integer size, Integer offset);

	public List<User> getListOfUsersByRole(Role role, Integer size,
			Integer offset);

	public Integer getCountOfUsersByRole(Role role);

	public User getUserByFeedback(Feedback feedback);

}
