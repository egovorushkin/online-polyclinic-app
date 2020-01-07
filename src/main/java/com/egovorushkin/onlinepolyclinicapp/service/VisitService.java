package com.egovorushkin.onlinepolyclinicapp.service;

import java.util.List;

import com.egovorushkin.onlinepolyclinicapp.entity.Visit;

public interface VisitService {

	public List<Visit> findAll();

	public Visit findById(int theId);

	public void save(Visit theVisit);

	public void deleteById(int theId);
}
