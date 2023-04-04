package com.devcamp.realestatebackend.controllers;

import com.devcamp.realestatebackend.models.Ward;
import com.devcamp.realestatebackend.repositories.IDistrictRepository;
import com.devcamp.realestatebackend.repositories.IWardRepository;
import com.devcamp.realestatebackend.services.WardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/wards")
public class WardController {

  @Autowired
  IWardRepository pWardRepository;

  @Autowired
  IDistrictRepository pDistrictRepository;

  @Autowired
  WardService pWardService;

  @GetMapping
  public ResponseEntity<List<Ward>> getAllWards() {
    try {
      return new ResponseEntity<>(
        pWardService.getAllWardsService(),
        HttpStatus.OK
      );
    } catch (Exception e) {
      // TODO: handle exception
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
