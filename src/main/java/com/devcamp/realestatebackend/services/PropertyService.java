package com.devcamp.realestatebackend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.realestatebackend.models.Property;
import com.devcamp.realestatebackend.repositories.IPropertyRepository;

@Service
public class PropertyService {
    @Autowired
    IPropertyRepository propertyRepository;

    public ArrayList<Property> getAllPropertiesService() {
        ArrayList<Property> listProperty = new ArrayList<Property>();
        propertyRepository.findAll().forEach(listProperty::add);
        return listProperty;
    }
}
