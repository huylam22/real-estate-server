package com.devcamp.realestatebackend.repositories;

import com.devcamp.realestatebackend.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Integer> {
  //
}
