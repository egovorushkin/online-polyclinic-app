package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.Patient;

public interface PatientService {

	public List<Patient> findAll();

	public Patient findById(int theId);

	public void save(Patient thePatient);

	public void deleteById(int theId);

}
