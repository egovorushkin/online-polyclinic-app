package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.Speciality;

public interface SpecialityService {

	public List<Speciality> findAll();

	public Speciality findById(int theId);

	public void save(Speciality theDoctor);

	public void deleteById(int theId);
}
