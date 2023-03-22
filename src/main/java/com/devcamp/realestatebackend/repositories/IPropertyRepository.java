package com.devcamp.realestatebackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.realestatebackend.models.Property;

public interface IPropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByPropertyLandType(String propertyLandType);
    
}
