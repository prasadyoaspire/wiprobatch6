package com.abc.mobileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.mobileservice.entity.Mobile;
import com.abc.mobileservice.exception.ResourceNotFoundException;
import com.abc.mobileservice.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {
	
	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Mobile saveMobile(Mobile mobile) {
		
		mobileRepository.save(mobile);
		return mobile;
	}

	@Override
	public Mobile getMobileById(int mobileId) {
		
		Optional<Mobile> optionalMobile = mobileRepository.findById(mobileId);
		
		if(optionalMobile.isEmpty()) {
			throw new ResourceNotFoundException("Mobile not existing with id: "+mobileId);
		}
		Mobile mobile = optionalMobile.get();		
		return mobile;
	}

	@Override
	public List<Mobile> getAllMobiles() {
	
		List<Mobile> mobiles = mobileRepository.findAll();
		return mobiles;
	}

}
