package com.devcamp.realestatebackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.realestatebackend.models.District;
import com.devcamp.realestatebackend.models.Property;
import com.devcamp.realestatebackend.models.Province;
import com.devcamp.realestatebackend.repositories.IDistrictRepository;
import com.devcamp.realestatebackend.repositories.IPropertyRepository;
import com.devcamp.realestatebackend.repositories.IProvinceRepository;
import com.devcamp.realestatebackend.repositories.IWardRepository;
import com.devcamp.realestatebackend.services.PropertyService;

@RestController
@CrossOrigin
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    IPropertyRepository propertyRepository;

    @Autowired
    PropertyService propertyService;

    @Autowired
    IProvinceRepository provinceRepository;

    @Autowired 
    IDistrictRepository districtRepository;

    @Autowired
    IWardRepository wardRepository;

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        try {
            return new ResponseEntity<>(propertyService.getAllPropertiesService(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
	public ResponseEntity<Object> getPropertyById(@RequestParam(value="propertyId", required = true) long id) {
        Optional<Property> propertyData = propertyRepository.findById(id);
        if (propertyData.isPresent()) {
            try {
                Property property = propertyData.get();
                return new ResponseEntity<>(property, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	    } else {
            Property propertyNull = new Property();
            return new ResponseEntity<>(propertyNull, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/{provinceId}/{id}")
    public ResponseEntity<Object> createProperty(@PathVariable("id") int id,
    @PathVariable("id") int provinceId, @RequestBody Property paramProperty) {
        try {
            Optional<Province> propertyProvince = provinceRepository.findById(provinceId);
            Optional<District> propertyDistrict = districtRepository.findById(id);
            if(propertyDistrict.isPresent()) {
                Property newProperty = new Property();
                newProperty.setPropertyAddressNumber(paramProperty.getPropertyAddressNumber());
                newProperty.setPropertyAddressStreet(paramProperty.getPropertyAddressStreet());
                newProperty.setPropertyArea(paramProperty.getPropertyArea());
                newProperty.setPropertyDescription(paramProperty.getPropertyDescription());
                newProperty.setPropertyFloorLocation(paramProperty.getPropertyFloorLocation());
                newProperty.setPropertyFloorUnits(paramProperty.getPropertyFloorUnits());
                newProperty.setPropertyLandDirection(paramProperty.getPropertyLandDirection());
                newProperty.setPropertyLandLegalStatus(paramProperty.getPropertyLandLegalStatus());
                newProperty.setPropertyLandType(paramProperty.getPropertyLandType());
                newProperty.setPropertyLength(paramProperty.getPropertyLength());
                newProperty.setPropertyPostingStatus(paramProperty.getPropertyPostingStatus());
                newProperty.setPropertyPrice(paramProperty.getPropertyPrice());
                newProperty.setPropertyWidth(paramProperty.getPropertyWidth());

                Province _province = propertyProvince.get();
                District _district = propertyDistrict.get();
                newProperty.setProvince(_province);
                newProperty.setDistrict(_district);
                Property savedProperty = propertyRepository.save(newProperty);
                return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("+++++++++++++++++++++::::: "+e.getCause().getCause().getMessage());
            //Hiện thông báo lỗi tra back-end
            //return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Property: "+e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProperty(@PathVariable("id") Long id, @RequestBody Property paramProperty) {
		Optional<Property> propertyData = propertyRepository.findById(id);
		if (propertyData.isPresent()) {
			Property newProperty = propertyData.get();
            newProperty.setPropertyAddressNumber(paramProperty.getPropertyAddressNumber());
            newProperty.setPropertyAddressStreet(paramProperty.getPropertyAddressStreet());
            newProperty.setPropertyArea(paramProperty.getPropertyArea());
            newProperty.setPropertyDescription(paramProperty.getPropertyDescription());
            newProperty.setPropertyFloorLocation(paramProperty.getPropertyFloorLocation());
            newProperty.setPropertyFloorUnits(paramProperty.getPropertyFloorUnits());
            newProperty.setPropertyLandDirection(paramProperty.getPropertyLandDirection());
            newProperty.setPropertyLandLegalStatus(paramProperty.getPropertyLandLegalStatus());
            newProperty.setPropertyLandType(paramProperty.getPropertyLandType());
            newProperty.setPropertyLength(paramProperty.getPropertyLength());
            newProperty.setPropertyPostingStatus(paramProperty.getPropertyPostingStatus());
            newProperty.setPropertyPrice(paramProperty.getPropertyPrice());
            newProperty.setPropertyWidth(paramProperty.getPropertyWidth());
			Property savedEmployee = propertyRepository.save(newProperty);
			return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProperty(@PathVariable("id") Long id) {
		try {
			propertyRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    // Xoá/delete tất cả voucher KHÔNG dùng service, sử dụng phương thức DELETE
    @DeleteMapping("/employees/delete-all")// Dùng phương thức DELETE
    public ResponseEntity<Property> deleteAllProperties() {
        try {
            propertyRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}