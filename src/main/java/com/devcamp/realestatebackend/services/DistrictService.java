package com.devcamp.realestatebackend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.realestatebackend.models.District;
import com.devcamp.realestatebackend.repositories.IDistrictRepository;

@Service
public class DistrictService {
    @Autowired
    IDistrictRepository pDistrictRepository;
    public ArrayList<District> getDistrictList() {
        ArrayList<District> pDistricts = new ArrayList<District>();
        pDistrictRepository.findAll().forEach(pDistricts::add);
        return pDistricts;
    }
}
