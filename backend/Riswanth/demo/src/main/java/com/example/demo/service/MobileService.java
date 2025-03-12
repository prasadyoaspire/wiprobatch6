package com.example.demo.service;

import com.example.demo.entity.Mobile;
import java.util.List;

// import org.springframework.stereotype.Service;

public interface MobileService {
    Mobile saveMobile(Mobile mobile);

    Mobile getMobileById(int mobileId);

    List<Mobile> getAllMobiles();

    Mobile updateMobile(Mobile mobile);

    void deleteMobile(int mobileId);
}
