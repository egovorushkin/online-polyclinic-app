package com.egovorushkin.onlinepolyclinicapp.dao;

import com.egovorushkin.onlinepolyclinicapp.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
}
