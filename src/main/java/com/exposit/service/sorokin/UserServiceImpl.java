package com.exposit.service.sorokin;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.repository.dao.sorokin.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6590198528411252719L;
	@Autowired
	private UserDao userRepository;

	@Override
	public void createNewUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByLoginAndPassword(String login, String password) {
		return userRepository.findUserByLoginAndPassword(login, password);
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);

	}

	@Override
	public List<User> findAllUsersByRole(Role role) {
		return userRepository.getListOfAllUsersByRole(role);
	}

	@Override
	public User findUserByName(String username) {
		return userRepository.findUserByName(username);
	}

	@Override
	public List<User> queryListOfUsers(Integer size, Integer offset) {
		return userRepository.queryListOfUsers(size, offset);
	}

	@Override
	public List<User> queryListOfUsersByRole(Role role, Integer size,
			Integer offset) {
		return userRepository.getListOfUsersByRole(role, size, offset);
	}

	@Override
	public Integer getCountOfUsers(Role role) {
		return userRepository.getCountOfUsersByRole(role);
	}

}
