package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
