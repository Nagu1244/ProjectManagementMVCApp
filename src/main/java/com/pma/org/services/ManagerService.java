package com.pma.org.services;

import java.util.Set;

import com.pma.org.entities.Manager;

public interface ManagerService {

 public void saveManagerDetails(Manager manager);
 public Set<Manager> getAllManagers();
}
