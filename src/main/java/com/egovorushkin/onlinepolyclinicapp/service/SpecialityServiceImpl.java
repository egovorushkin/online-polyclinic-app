package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egovorushkin.onlinepolyclinicapp.dao.SpecialityRepository;
import com.egovorushkin.onlinepolyclinicapp.entity.Speciality;

@Service
public class SpecialityServiceImpl implements SpecialityService {
	
	private SpecialityRepository specialtyRepository;
	
	@Autowired
	public SpecialityServiceImpl(SpecialityRepository theSpecialtyRepository) {
		specialtyRepository = theSpecialtyRepository;
	}

	@Override
	public List<Speciality> findAll() {
		
		return specialtyRepository.findAll();
	}

	@Override
	public Speciality findById(int theId) {
		
		Optional<Speciality> result = specialtyRepository.findById(theId);

		Speciality theSpecialty = null;

		if (result.isPresent()) {
			theSpecialty = result.get();
		} else {
			// we didn't find the specialty
			throw new RuntimeException("Did not find specialty id - " + theId);
		}
		return theSpecialty;
	}

	@Override
	public void save(Speciality theSpecialty) {
		specialtyRepository.save(theSpecialty);
	}

	@Override
	public void deleteById(int theId) {
		specialtyRepository.deleteById(theId);
	}

}
