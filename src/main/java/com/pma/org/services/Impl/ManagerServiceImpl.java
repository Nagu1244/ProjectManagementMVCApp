package com.pma.org.services.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.org.entities.Manager;
import com.pma.org.repositories.ManagerRepository;
import com.pma.org.services.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
     
	@Autowired
	private ManagerRepository managerRepo;
	public void saveManagerDetails(Manager manager) {
		
		managerRepo.save(manager);
		
		
	}
	@Override
	public Set<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		List<Manager> listManagers= managerRepo.findAll();
		Set<Manager> setManagers=new HashSet<>(listManagers);
		return setManagers;
	}

}
