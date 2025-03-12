package com.example.demo.service.impl;

import java.util.Optional;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Mobile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MobileRepository;
import com.example.demo.service.MobileService;

// import com.example.demo.service.MobileService;
@Service
public class MobileServiceimpl implements MobileService {
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
        if (optionalMobile.isEmpty()) {
            throw new ResourceNotFoundException("mobile not existing" + mobileId);
        }
        Mobile mobile = optionalMobile.get();
        return mobile;
    }

    @Override
    public List<Mobile> getAllMobiles() {
        List<Mobile> mobiles = mobileRepository.findAll();
        return mobiles;
    }

    @Override
    public Mobile updateMobile(Mobile mobile) {

        Optional<Mobile> optionalMobile = mobileRepository.findById(mobile.getMobileId());
        if (optionalMobile.isEmpty()) {
            throw new ResourceNotFoundException("Mobile not existing with id: " + mobile.getMobileId());
        }
        mobileRepository.save(mobile);
        return mobile;
    }

    @Override
    public void deleteMobile(int mobileId) {

        Optional<Mobile> optionalMobile = mobileRepository.findById(mobileId);
        if (optionalMobile.isEmpty()) {
            throw new ResourceNotFoundException("Mobile not existing with id: " + mobileId);
        }
        Mobile mobile = optionalMobile.get();
        mobileRepository.delete(mobile);
    }

}
