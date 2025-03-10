package com.abc.investment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class InvestmentDTO {

	private Long id;
	private Double amount;
	private String investorName;
	private Long projectId;	
}
