package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;

public interface UserService {

	public void createNewUser(User user);

	public void deleteUser(User user);

	public User getUserById(int id);

	public List<User> getUsers();

	public void updateUser(User user);

	public User findUserByLoginAndPassword(String login, String password);

	public List<User> findAllUsersByRole(Role role);

	public User findUserByName(String username);

	public List<User> queryListOfUsers(Integer size, Integer offset);

	public List<User> queryListOfUsersByRole(Role role, Integer size,
			Integer offset);

	public Integer getCountOfUsers(Role role);
}
