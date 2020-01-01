package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
