package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.base.GenericDao;

public interface UserDao extends GenericDao<User, Integer> {

	public List<User> getListOfAllUsersByRole(Role role);

	public List<User> getListOfAllUsersByBonus(Bonus bonus);

	public User findUserByLoginAndPassword(String login,String password);

	

}
