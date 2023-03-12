package com.devcamp.realestatebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.realestatebackend.models.Ward;

public interface IWardRepository extends JpaRepository<Ward, Integer>{
    
}
