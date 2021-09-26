package com.pma.org.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pma.org.dto.ProjectStageCount;
import com.pma.org.dto.TimeChartDate;
import com.pma.org.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	@Query(nativeQuery = true, value = "SELECT name as projectName,stage as label,count(stage) as value from  projectmanagementapp.project_tb group by stage")
	List<ProjectStageCount> projectStageCount();

	@Query(nativeQuery = true, value = "select name as projectName,start_date as startDate,end_date as endDate from project_tb where start_date is not null group by name")
	List<TimeChartDate> getTimeData();

	Project findByProjectId(Long projectId);
}
