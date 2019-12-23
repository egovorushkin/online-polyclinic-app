package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer>{

}
