package com.devcamp.realestatebackend.controllers;

import com.devcamp.realestatebackend.services.PropertyPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/properties/photos")
public class PropertyPhotoController {

  @Autowired
  private PropertyPhotoService propertyPhotoService;

  @PostMapping("/upload/{propertyId}")
  public ResponseEntity<String> uploadFile(
    @RequestParam(value = "file") MultipartFile file,
    @PathVariable Long propertyId
  ) {
    return new ResponseEntity<>(
      propertyPhotoService.uploadFile(file, propertyId),
      HttpStatus.OK
    );
  }

  @GetMapping("/download/{fileName}")
  public ResponseEntity<ByteArrayResource> downloadFile(
    @PathVariable String fileName
  ) {
    byte[] data = propertyPhotoService.downloadFile(fileName);
    ByteArrayResource resource = new ByteArrayResource(data);
    return ResponseEntity
      .ok()
      .contentLength(data.length)
      .header("Content-type", "application/octet-stream")
      .header(
        "Content-disposition",
        "attachment; filename=\"" + fileName + "\""
      )
      .body(resource);
  }

  @DeleteMapping("/delete/{fileName}")
  public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
    return new ResponseEntity<>(
      propertyPhotoService.deleteFile(fileName),
      HttpStatus.OK
    );
  }
}
