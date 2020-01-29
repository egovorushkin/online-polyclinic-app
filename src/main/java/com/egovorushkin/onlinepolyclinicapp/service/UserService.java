package com.egovorushkin.onlinepolyclinicapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.egovorushkin.onlinepolyclinicapp.entity.User;
import com.egovorushkin.onlinepolyclinicapp.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);
	
	void save(CrmUser crmUser);
}
