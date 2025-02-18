package com.abc.mobilestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.mobilestore.entity.Mobile;
import com.abc.mobilestore.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileService mobileService;
	
	@PostMapping("/save")
	public ResponseEntity<Mobile> addMobile(@RequestBody  Mobile mobile) {	
		
		mobileService.saveMobile(mobile);		
		ResponseEntity<Mobile> responseEntity = new ResponseEntity<>(mobile,HttpStatus.CREATED);		
		return responseEntity;		
	}
	
	@GetMapping("/{mobileId}")
	public ResponseEntity<Mobile> fetchMobileDetails(@PathVariable int mobileId) {	
		
		Mobile mobile = mobileService.getMobileById(mobileId);		
		ResponseEntity<Mobile> responseEntity = new ResponseEntity<>(mobile,HttpStatus.OK);		
		return responseEntity;	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Mobile>> fetchAllMobiles() {		
		
		List<Mobile> mobiles = mobileService.getAllMobiles();	
		ResponseEntity<List<Mobile>> responseEntity = new ResponseEntity<>(mobiles,HttpStatus.OK);		
		return responseEntity;			
	}
}
