package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.MedicalService;

public interface MedicalServiceRepisitory extends JpaRepository<MedicalService, Integer>{

}
