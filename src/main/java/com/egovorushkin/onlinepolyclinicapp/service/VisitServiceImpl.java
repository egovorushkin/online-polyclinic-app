package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egovorushkin.onlinepolyclinicapp.dao.VisitRepository;
import com.egovorushkin.onlinepolyclinicapp.entity.Visit;

@Service
public class VisitServiceImpl implements VisitService {

	private VisitRepository visitRepository;

	@Autowired
	public VisitServiceImpl(VisitRepository theVisitRepository) {
		visitRepository = theVisitRepository;
	}

	@Override
	public List<Visit> findAll() {

		return visitRepository.findAll();
	}

	@Override
	public Visit findById(int theId) {
		Optional<Visit> result = visitRepository.findById(theId);

		Visit theVisit = null;

		if (result.isPresent()) {
			theVisit = result.get();
		} else {
			throw new RuntimeException("Did not find visit id - " + theId);
		}
		return theVisit;
	}

	@Override
	public void save(Visit theVisit) {
		visitRepository.save(theVisit);
	}

	@Override
	public void deleteById(int theId) {
		visitRepository.deleteById(theId);
	}

}
