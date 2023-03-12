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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.realestatebackend.models.Province;
import com.devcamp.realestatebackend.repositories.IProvinceRepository;
import com.devcamp.realestatebackend.services.ProvinceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    IProvinceRepository pProvinceRepository;
    @Autowired
    ProvinceService pProvinceService;
    
    // Lấy all province dùng service
    @GetMapping
    public ResponseEntity<List<Province>> getAllProvincesByService() {
        try {
            return new ResponseEntity<>(pProvinceService.getProvinceList(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Lấy province theo {id} dùng service
    @GetMapping("/details/{id}")// Dùng phương thức GET
    public ResponseEntity<Province> getProvincesById(@PathVariable("id") int id) {
        try {
            Optional<Province> provinceData = pProvinceRepository.findById(id);
                if (provinceData.isPresent()) {
                    return new ResponseEntity<>(provinceData.get(), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }

    // Tạo MỚI province sử dụng phương thức POST
    @PostMapping("/create")// Dùng phương thức POST
    public ResponseEntity<Object> createCProvince(@RequestBody Province pProvinces) {        
        try {   
            Optional<Province> provinceData = pProvinceRepository.findById(pProvinces.getId());
            if(provinceData.isPresent()) {
                return ResponseEntity.unprocessableEntity().body(" Province already exsit  ");
            }
            Province _provinces = pProvinceRepository.save(pProvinces);
            return new ResponseEntity<>(_provinces, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++++::::: "+e.getCause().getCause().getMessage());
            //Hiện thông báo lỗi tra back-end
            //return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Province: "+e.getCause().getCause().getMessage());
        }
    }

            // Sửa/update province theo {id} KHÔNG dùng service, sử dụng phương thức PUT
    @PutMapping("/update/{id}")// Dùng phương thức PUT
	public ResponseEntity<Object> updateCProvinceById(@PathVariable("id") int id, @RequestBody Province pProvinces) {
		try {
			Optional<Province> provinceData = pProvinceRepository.findById(id);
			if (provinceData.isPresent()) {
				Province newProvince = provinceData.get();
				// if (pProvinces.getProvinceCode() != null && !pProvinces.getProvinceCode().isEmpty()) {
                    newProvince.setProvinceCode(pProvinces.getProvinceCode());
				// }
				// if (pProvinces.getProvinceName() != null && !pProvinces.getProvinceName().isEmpty()) {
                    newProvince.setProvinceName(pProvinces.getProvinceName());
				// }
                Province _province = pProvinceRepository.save(newProvince);
					return new ResponseEntity<>(_province, HttpStatus.OK);	
			} else {
				return ResponseEntity.badRequest().body("Failed to get specified Voucher: "+id + "  for update.");
			}
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body("Failed to Update specified Voucher:"+e.getCause().getCause().getMessage());
		}
	}

    // Xoá/delete province theo {id} KHÔNG dùng service, sử dụng phương thức DELETE
    @DeleteMapping("/delete/{id}")// Dùng phương thức DELETE
    public ResponseEntity<Province> deleteCProvinceById(@PathVariable("id") int id) {
        try {
            Optional<Province> provinceData = pProvinceRepository.findById(id);
            if (provinceData.isPresent()) {
                pProvinceRepository.deleteById(id);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
