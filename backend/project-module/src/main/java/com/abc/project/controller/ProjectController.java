package com.abc.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.project.dto.ProjectDTO;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@PostMapping("/")
	public ProjectDTO addProject(@RequestBody ProjectDTO productDTO) {
		
		return null;		
	}
	
	@GetMapping("/{projectId}")
	public ProjectDTO fetchProject(@PathVariable long projectId) {
		
		return null;		
	}
	
	@GetMapping("/")
	public List<ProjectDTO> fetchAllProject() {
		
		return null;		
	}
	
	@PutMapping("/{projectId}")
	public ProjectDTO updateProject(@PathVariable long projectId, @RequestBody ProjectDTO productDTO) {
		
		return null;		
	}
	
	@DeleteMapping("/{projectId}")
	public void deleteProject(@PathVariable long projectId) {		
			
	}
}
