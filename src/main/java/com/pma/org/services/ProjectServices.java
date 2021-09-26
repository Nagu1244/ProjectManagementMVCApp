package com.pma.org.services;

import java.util.List;

import com.pma.org.entities.Project;

public interface ProjectServices {
 
	void saveProject(Project project);
	
	List<Project> getListOfProjects();
}
