package com.pma.org.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pma.org.dto.TimeChartDate;
import com.pma.org.entities.Project;
import com.pma.org.repositories.ProjectRepository;
import com.pma.org.services.ProjectServices;
@Service
public class ProjectServiceImpl implements ProjectServices {
    
	@Autowired
	private ProjectRepository repo;
	@Override
	public void saveProject(Project project) {
		
		repo.save(project);
		
		
	}
	@Override
	public List<Project> getListOfProjects() {
		
		return repo.findAll();
	}

	public List<TimeChartDate> getTimeChartData()
	{
		List<TimeChartDate> timeChartDate=repo.getTimeData();
		return timeChartDate;
	}
	
	public Project findByProjectId(Long projectId)
	{
		return repo.findById(projectId).get();
		}
	public void deleteProjectById(Long projectId) {
		
		repo.deleteById(projectId);
		
	}
}
