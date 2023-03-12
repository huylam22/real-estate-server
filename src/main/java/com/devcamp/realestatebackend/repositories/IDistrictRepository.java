package com.devcamp.realestatebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.realestatebackend.models.District;

public interface IDistrictRepository extends JpaRepository<District, Integer>{
    
}
