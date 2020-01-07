package com.egovorushkin.onlinepolyclinicapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egovorushkin.onlinepolyclinicapp.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}
