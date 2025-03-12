package com.example.demo.entity;

import java.time.LocalDate;

// import com.fasterxml.jackson.annotation.JsonGetter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.Version;

@Entity
@Table(name = "mobile_tbl")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mobileId;
    private String mobileName;
    private double price;
    private LocalDate mfd;
    private String companyName;
    // @Version
    // private Long version;

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getMfd() {
        return mfd;
    }

    public void setMfd(LocalDate mfd) {
        this.mfd = mfd;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
