package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.Administrator;

public interface AdministratorService {

	public List<Administrator> findAll();

	public Administrator findById(int theId);

	public void save(Administrator theAdministrator);

	public void deleteById(int theId);
}
