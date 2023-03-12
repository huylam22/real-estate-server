package com.devcamp.realestatebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.realestatebackend.models.Property;

public interface IPropertyRepository extends JpaRepository<Property, Long> {
    
}
