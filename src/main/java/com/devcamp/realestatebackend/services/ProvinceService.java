package com.devcamp.realestatebackend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.realestatebackend.models.Province;
import com.devcamp.realestatebackend.repositories.IProvinceRepository;

@Service
public class ProvinceService {
    @Autowired
    IProvinceRepository pProvinceRepository;
    public ArrayList<Province> getProvinceList() {
        ArrayList<Province> pProvinces = new ArrayList<Province>();
        pProvinceRepository.findAll().forEach(pProvinces::add);
        return pProvinces;
    }
}
