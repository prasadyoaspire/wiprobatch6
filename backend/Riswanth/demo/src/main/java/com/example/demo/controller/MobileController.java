package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mobile;
// import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.MobileService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/mobile")
public class MobileController {
    @Autowired
    private MobileService mobileService;

    @PostMapping("/save")
    public Mobile addMobile(@RequestBody Mobile mobile) {
        mobileService.saveMobile(mobile);
        return mobile;
    }

    @GetMapping("/{mobileId}")
    public Mobile fetchMobileDetails(@PathVariable int mobileId) {
        Mobile mobile = mobileService.getMobileById(mobileId);

        return mobile;
    }

    // @PreAuthorize("hasRole("USER")
    @GetMapping("/all")
    public List<Mobile> fetchAllMobiles() {
        return mobileService.getAllMobiles();

    }

    @PutMapping("/update")
    public ResponseEntity<Mobile> editMobile(@RequestBody Mobile mobile) {

        mobileService.updateMobile(mobile);
        ResponseEntity<Mobile> responseEntity = new ResponseEntity<>(mobile, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{mobileId}")
    public ResponseEntity<Void> deleteMobile(@PathVariable int mobileId) {

        mobileService.deleteMobile(mobileId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        return responseEntity;
    }

}
