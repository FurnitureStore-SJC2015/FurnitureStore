package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.User;

public interface UserService {

	public void createNewUser(User user);

	public void deleteUser(User user);

	public User getUserById(int id);

	public List<User> getUsers();

	public User findUserByLoginAndPassword(String login, String password);

}
