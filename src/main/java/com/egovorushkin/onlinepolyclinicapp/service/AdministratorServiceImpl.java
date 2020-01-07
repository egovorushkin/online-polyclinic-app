package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.egovorushkin.onlinepolyclinicapp.dao.AdministratorRepository;
import com.egovorushkin.onlinepolyclinicapp.entity.Administrator;

public class AdministratorServiceImpl implements AdministratorService {

	private AdministratorRepository administratorRepository;

	@Autowired
	public AdministratorServiceImpl(AdministratorRepository theAdministratorRepository) {
		administratorRepository = theAdministratorRepository;
	}

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	public Administrator findById(int theId) {
		Optional<Administrator> result = administratorRepository.findById(theId);

		Administrator theAdministrator = null;

		if (result.isPresent()) {
			theAdministrator = result.get();
		} else {
			// we didn't find the diagnosis
			throw new RuntimeException("Did not find administrator id - " + theId);
		}
		return theAdministrator;
	}

	@Override
	public void save(Administrator theAdministrator) {
		administratorRepository.save(theAdministrator);
	}

	@Override
	public void deleteById(int theId) {
		administratorRepository.deleteById(theId);
	}

}
