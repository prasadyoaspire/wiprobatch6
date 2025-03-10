package com.abc.project.service;

import java.util.List;

import com.abc.project.dto.ProjectDTO;

public interface ProjectService {

	ProjectDTO createProject(ProjectDTO projectDTO);

	ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO);

	boolean deleteProject(Long projectId);

	ProjectDTO getProjectById(Long projectId);

	List<ProjectDTO> getAllProjects();
}
