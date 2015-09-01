package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
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
