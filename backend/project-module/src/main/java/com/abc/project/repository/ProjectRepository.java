package com.abc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {

	
}
