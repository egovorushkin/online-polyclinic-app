package com.egovorushkin.onlinepolyclinicapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	// method to sort by last name
	public List<Doctor> findByOrderByLastNameAsc();
}
