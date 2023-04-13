package com.SpringBootReact.PPMTool.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootReact.PPMTool.domain.Project;
import com.SpringBootReact.PPMTool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) { 
		return projectRepository.save(project);
	}
}
