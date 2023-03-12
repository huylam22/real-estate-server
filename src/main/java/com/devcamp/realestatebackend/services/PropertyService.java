package com.devcamp.realestatebackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.realestatebackend.models.Property;
import com.devcamp.realestatebackend.repositories.IPropertyRepository;
import com.devcamp.realestatebackend.services.DTO.PropertyDTO;

@Service
public class PropertyService {
    @Autowired
    IPropertyRepository propertyRepository;

    public ArrayList<Property> getAllPropertiesService() {
        ArrayList<Property> listProperty = new ArrayList<Property>();
        propertyRepository.findAll().forEach(listProperty::add);
        return listProperty;
    }

    public List<PropertyDTO> getAllPropertiesDTOService() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyDTO> propertyDTOs = properties.stream()
        .map(PropertyDTO::new)
        .collect(Collectors.toList());
        return propertyDTOs;
        }
}
