package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.MedicalService;

public interface MedicalServiceService {

	public List<MedicalService> findAll();

	public MedicalService findById(int theId);

	public void save(MedicalService theMedicalService	);

	public void deleteById(int theId);
}
