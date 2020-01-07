package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

}
