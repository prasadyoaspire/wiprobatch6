package com.abc.investment.service;

import java.util.List;

import com.abc.investment.dto.InvestmentDTO;

public interface InvestmentService {

	InvestmentDTO makeInvestment(InvestmentDTO investmentDTO);

	InvestmentDTO updateInvestment(Long investmentId, InvestmentDTO investmentDTO);

	boolean deleteInvestment(Long investmentId);

	InvestmentDTO getInvestmentById(Long investmentId);

	List<InvestmentDTO> getInvestmentsByProjectId(Long projectId);

	List<InvestmentDTO> getInvestmentsByInvestorName(String investorName);
}
