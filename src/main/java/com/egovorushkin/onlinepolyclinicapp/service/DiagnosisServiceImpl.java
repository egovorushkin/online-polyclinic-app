package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egovorushkin.onlinepolyclinicapp.dao.DiagnosisRepository;
import com.egovorushkin.onlinepolyclinicapp.entity.Diagnosis;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	private DiagnosisRepository diagnosisRepository;

	@Autowired
	public DiagnosisServiceImpl(DiagnosisRepository theDiagnosisRepository) {
		diagnosisRepository = theDiagnosisRepository;
	}

	@Override
	public List<Diagnosis> findAll() {
		return diagnosisRepository.findAll();
	}

	@Override
	public Diagnosis findById(int theId) {
		Optional<Diagnosis> result = diagnosisRepository.findById(theId);

		Diagnosis theDiagnosis = null;

		if (result.isPresent()) {
			theDiagnosis = result.get();
		} else {
			// we didn't find the diagnosis
			throw new RuntimeException("Did not find diagnosis id - " + theId);
		}
		return theDiagnosis;
	}

	@Override
	public void save(Diagnosis theDiagnosis) {
		diagnosisRepository.save(theDiagnosis);
	}

	@Override
	public void deleteById(int theId) {
		diagnosisRepository.deleteById(theId);
	}

}
