package com.SpringBootReact.PPMTool.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootReact.PPMTool.Service.MapServiceErrorValidation;
import com.SpringBootReact.PPMTool.Service.ProjectService;
import com.SpringBootReact.PPMTool.domain.Project;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapServiceErrorValidation mapServiceErrorValidation;
	@PostMapping("")
	public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project , BindingResult result){
		
		ResponseEntity<?> errorMap = mapServiceErrorValidation.MapServiceValidation(result);
		if(errorMap != null) return errorMap;
		Project project1 = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project , HttpStatus.CREATED);
	}
	
	
}
