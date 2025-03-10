package com.abc.investment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.investment.dto.InvestmentDTO;

@CrossOrigin
@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

	
	@GetMapping("/{investmentId}")
	public InvestmentDTO fetchInvestmentDetails(@PathVariable Long investmentId) {
		
		return null;	
	}
	
	@GetMapping("/project/{projectId}")
	public List<InvestmentDTO> fetchInvestmentByProject(@PathVariable Long projectId) {
		
		return null;
	}
	
	@PostMapping("")
	public InvestmentDTO saveInvestment(@RequestBody InvestmentDTO investmentDTO) {		

		return null;
	}
	
	@PutMapping("/{investmentId}")
	public InvestmentDTO editInvestment(@PathVariable Long investmentId,@RequestBody InvestmentDTO investmentDTO) {	
		
		return null;
	}
	
	@DeleteMapping("/{investmentId}")
	public void removeInvestment(@PathVariable Long investmentId) {
	
		
	}
	
	@GetMapping("/investor/{investorName}")
	public List<InvestmentDTO> fetchInvestmentByInvestor(@PathVariable String investorName) {
		
		return null;
	}
	
}
