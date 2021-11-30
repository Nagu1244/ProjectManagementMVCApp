package com.pma.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pma.org.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
