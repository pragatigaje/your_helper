package com.yourhelp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yourhelp.entity.User;



public interface UserService {
	List<User> getAllUsers();

	void saveUser(User user);

	User getUserById(int id);

	void deleteUserById(int id);

	Page<User> findPaginated(int pageNo, int pageSize);

}
