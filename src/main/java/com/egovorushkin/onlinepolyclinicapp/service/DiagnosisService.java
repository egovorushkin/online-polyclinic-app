package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.Diagnosis;

public interface DiagnosisService {

public List<Diagnosis> findAll();
	
	public Diagnosis findById(int theId);
	
	public void save(Diagnosis theDiagnosis);
	
	public void deleteById(int theId);
}
