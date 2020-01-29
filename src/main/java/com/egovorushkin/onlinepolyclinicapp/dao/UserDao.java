package com.egovorushkin.onlinepolyclinicapp.dao;

import com.egovorushkin.onlinepolyclinicapp.entity.User;

public interface UserDao {

	User findByUserName(String userName);
	
	void save(User theUser);
}
