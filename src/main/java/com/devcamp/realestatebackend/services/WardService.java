package com.devcamp.realestatebackend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.realestatebackend.models.Ward;
import com.devcamp.realestatebackend.repositories.IWardRepository;

@Service
public class WardService {
    @Autowired
    IWardRepository pWardRepository;

    public ArrayList<Ward> getAllWardsService() {  
        ArrayList<Ward> listWards = new ArrayList<>();
        pWardRepository.findAll().forEach(listWards::add);
        return listWards;
    }
}
