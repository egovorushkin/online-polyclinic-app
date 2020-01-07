package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egovorushkin.onlinepolyclinicapp.dao.MedicalServiceRepisitory;
import com.egovorushkin.onlinepolyclinicapp.entity.MedicalService;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

	private MedicalServiceRepisitory medicalServiceRepository;

	@Autowired
	public MedicalServiceServiceImpl(MedicalServiceRepisitory theMedicalServiceRepository) {
		medicalServiceRepository = theMedicalServiceRepository;
	}

	@Override
	public List<MedicalService> findAll() {
		return medicalServiceRepository.findAll();
	}

	@Override
	public MedicalService findById(int theId) {

		Optional<MedicalService> result = medicalServiceRepository.findById(theId);

		MedicalService theMedicalService = null;

		if (result.isPresent()) {
			theMedicalService = result.get();
		} else {
			// we didn't find the medical service
			throw new RuntimeException("Did not find medical service id - " + theId);
		}
		return theMedicalService;
	}

	@Override
	public void save(MedicalService theMedicalService) {
		medicalServiceRepository.save(theMedicalService);
	}

	@Override
	public void deleteById(int theId) {
		medicalServiceRepository.deleteById(theId);
	}

}
