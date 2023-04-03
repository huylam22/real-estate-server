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
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.realestatebackend.models.District;
import com.devcamp.realestatebackend.models.Province;
import com.devcamp.realestatebackend.repositories.IDistrictRepository;
import com.devcamp.realestatebackend.repositories.IProvinceRepository;
import com.devcamp.realestatebackend.services.DistrictService;

@RestController
@CrossOrigin
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    IDistrictRepository pDistrictRepository;
    @Autowired
    DistrictService pDistrictService;
    @Autowired
    IProvinceRepository pProvinceRepository;
    
    // Lấy all district dùng service
    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        try {
            return new ResponseEntity<>(pDistrictService.getDistrictList(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Lấy district theo {id} dùng service
    @GetMapping("/details/{id}")// Dùng phương thức GET
    public ResponseEntity<District> getDistrictById(@PathVariable("id") int id) {
        try {
            Optional<District> districtData = pDistrictRepository.findById(id);
                if (districtData.isPresent()) {
                    return new ResponseEntity<>(districtData.get(), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }

     // Tạo MỚI District sử dụng phương thức POST
    //  @CrossOrigin
     @PostMapping("/create/{id}")// Dùng phương thức POST
     public ResponseEntity<Object> createCDistrict(@PathVariable("id") int id, @RequestBody District pDistricts) {        
         try {   
             Optional<Province> provinceData = pProvinceRepository.findById(id);
             if(provinceData.isPresent()) {
                District newDistrict = new District();
                newDistrict.setDistrictName(pDistricts.getDistrictName());
                newDistrict.setDistrictPrefix(pDistricts.getDistrictPrefix());
                newDistrict.setId(pDistricts.getId());
                
                Province _province = provinceData.get();
                newDistrict.setProvince(_province);
                
                District savedDistrict = pDistrictRepository.save(newDistrict);
                return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
             }
         } catch (Exception e) {
             System.out.println("+++++++++++++++++++++::::: "+e.getCause().getCause().getMessage());
             //Hiện thông báo lỗi tra back-end
             //return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
             return ResponseEntity.unprocessableEntity().body("Failed to Create specified Province: "+e.getCause().getCause().getMessage());
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

        // Sửa/update voucher theo {id} KHÔNG dùng service, sử dụng phương thức PUT
    @PutMapping("/update/{id}")// Dùng phương thức PUT
	public ResponseEntity<Object> updateCProvinceById(@PathVariable("id") int id, @RequestBody District pDistricts) {
		try {
			Optional<District> districtData = pDistrictRepository.findById(id);
			if (districtData.isPresent()) {
				District newDistrict = districtData.get();
				// if (pProvinces.getProvinceCode() != null && !pProvinces.getProvinceCode().isEmpty()) {
                    newDistrict.setDistrictName(pDistricts.getDistrictName());
				// }
				// if (pProvinces.getProvinceName() != null && !pProvinces.getProvinceName().isEmpty()) {
                    newDistrict.setDistrictPrefix(pDistricts.getDistrictPrefix());
				// }
                District _district = pDistrictRepository.save(newDistrict);
					return new ResponseEntity<>(_district, HttpStatus.OK);	
			} else {
				return ResponseEntity.badRequest().body("Failed to get specified Voucher: "+id + "  for update.");
			}
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body("Failed to Update specified Voucher:"+e.getCause().getCause().getMessage());
		}
	}

    // Xoá/delete province theo {id} KHÔNG dùng service, sử dụng phương thức DELETE
    @DeleteMapping("/delete/{id}")// Dùng phương thức DELETE
    public ResponseEntity<District> deleteCProvinceById(@PathVariable("id") int id) {
        try {
            Optional<District> districtData = pDistrictRepository.findById(id);
            if (districtData.isPresent()) {
                pDistrictRepository.deleteById(id);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
