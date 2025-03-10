package com.abc.project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDTO {

	private long Id;
	private String projectName;
	private String description;
	private double goalAmount;
	private double amountRaised;
}
