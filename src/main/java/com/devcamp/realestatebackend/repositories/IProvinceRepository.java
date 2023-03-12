package com.devcamp.realestatebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.realestatebackend.models.Province;

public interface IProvinceRepository extends JpaRepository<Province, Integer> {
    
}
