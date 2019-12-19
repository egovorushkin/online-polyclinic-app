package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egovorushkin.onlinepolyclinicapp.dao.DoctorRepository;
import com.egovorushkin.onlinepolyclinicapp.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;

	// set up constructor injection
	@Autowired
	public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
		doctorRepository = theDoctorRepository;
	}

	// change a new method "findByAllByOrderBylastNameAsc()"
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findByOrderByLastNameAsc();
	}

	@Override
	public Doctor findById(int theId) {
		Optional<Doctor> result = doctorRepository.findById(theId);

		Doctor theDoctor = null;

		if (result.isPresent()) {
			theDoctor = result.get();
		} else {
			// we didn't find the doctor
			throw new RuntimeException("Did not find doctor id - " + theId);
		}
		return theDoctor;
	}

	@Override
	public void save(Doctor theDoctor) {
		doctorRepository.save(theDoctor);
	}

	@Override
	public void deleteById(int theId) {
		doctorRepository.deleteById(theId);
	}

}
