package com.lyr_ssh.service;

import com.lyr_ssh.entity.User;

public interface UserService {

	/**
	 * 根据用户名查找用户
	 */
	User getByUserCode(String userCode);

	User getByUserByCodePassword(User user);
	//注册用户
	void saveUser(User u);
}
