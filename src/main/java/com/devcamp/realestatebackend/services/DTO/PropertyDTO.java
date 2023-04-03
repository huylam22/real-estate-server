package com.devcamp.realestatebackend.services.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.devcamp.realestatebackend.models.Property;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PropertyDTO {
    private long id;
    private String propertyAddressNumber;
    private String propertyAddressStreet;
    private float propertyArea;
    private float propertyWidth;
    private float propertyLength;
    private int propertyFloorUnits;
    private String propertyFloorLocation;
    private float propertyPrice;
    private String propertyLandType;
    private String propertyLandDirection;
    private String propertyLandLegalStatus;
    private String propertyDescription;
    private String propertyPostingStatus;
    private int propertyBedrooms;
    private int propertyBathrooms;
    private int provinceId;
    private int districtId;
    private String provincePrefix;
    private String districtPrefix;
    private String districtName;
    private String provinceName;
    private List<String> propertyCoverPaths;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime createdDate;
    
    public PropertyDTO(Property property) {
        this.id = property.getId();
        this.propertyAddressNumber = property.getPropertyAddressNumber();
        this.propertyAddressStreet = property.getPropertyAddressStreet();
        this.propertyArea = property.getPropertyArea();
        this.propertyWidth = property.getPropertyWidth();
        this.propertyLength = property.getPropertyLength();
        this.propertyFloorUnits = property.getPropertyFloorUnits();
        this.propertyFloorLocation = property.getPropertyFloorLocation();
        this.propertyPrice = property.getPropertyPrice();
        this.propertyLandType = property.getPropertyLandType();
        this.propertyLandDirection = property.getPropertyLandDirection();
        this.propertyLandLegalStatus = property.getPropertyLandLegalStatus();
        this.propertyDescription = property.getPropertyDescription();
        this.propertyPostingStatus = property.getPropertyPostingStatus();
        this.provinceId = property.getProvince().getId();
        this.districtId = property.getDistrict().getId();
        this.provincePrefix = property.getProvince().getProvinceCode();
        this.provinceName = property.getProvince().getProvinceName();
        this.districtPrefix = property.getDistrict().getDistrictPrefix();
        this.districtName = property.getDistrict().getDistrictName();
        this.createdDate = property.getCreatedDate();
        this.propertyBathrooms = property.getPropertyBathrooms();
        this.propertyBedrooms = property.getPropertyBedrooms();
        this.propertyCoverPaths = property.getPropertyCoverPaths();
    }

    public PropertyDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPropertyAddressNumber() {
        return propertyAddressNumber;
    }

    public void setPropertyAddressNumber(String propertyAddressNumber) {
        this.propertyAddressNumber = propertyAddressNumber;
    }

    public String getPropertyAddressStreet() {
        return propertyAddressStreet;
    }

    public void setPropertyAddressStreet(String propertyAddressStreet) {
        this.propertyAddressStreet = propertyAddressStreet;
    }

    public float getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(float propertyArea) {
        this.propertyArea = propertyArea;
    }

    public float getPropertyWidth() {
        return propertyWidth;
    }

    public void setPropertyWidth(float propertyWidth) {
        this.propertyWidth = propertyWidth;
    }

    public float getPropertyLength() {
        return propertyLength;
    }

    public void setPropertyLength(float propertyLength) {
        this.propertyLength = propertyLength;
    }

    public int getPropertyFloorUnits() {
        return propertyFloorUnits;
    }

    public void setPropertyFloorUnits(int propertyFloorUnits) {
        this.propertyFloorUnits = propertyFloorUnits;
    }

    public String getPropertyFloorLocation() {
        return propertyFloorLocation;
    }

    public void setPropertyFloorLocation(String propertyFloorLocation) {
        this.propertyFloorLocation = propertyFloorLocation;
    }

    public float getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(float propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyLandType() {
        return propertyLandType;
    }

    public void setPropertyLandType(String propertyLandType) {
        this.propertyLandType = propertyLandType;
    }

    public String getPropertyLandDirection() {
        return propertyLandDirection;
    }

    public void setPropertyLandDirection(String propertyLandDirection) {
        this.propertyLandDirection = propertyLandDirection;
    }

    public String getPropertyLandLegalStatus() {
        return propertyLandLegalStatus;
    }

    public void setPropertyLandLegalStatus(String propertyLandLegalStatus) {
        this.propertyLandLegalStatus = propertyLandLegalStatus;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getPropertyPostingStatus() {
        return propertyPostingStatus;
    }

    public void setPropertyPostingStatus(String propertyPostingStatus) {
        this.propertyPostingStatus = propertyPostingStatus;
    }

    public int getPropertyBedrooms() {
        return propertyBedrooms;
    }

    public void setPropertyBedrooms(int propertyBedrooms) {
        this.propertyBedrooms = propertyBedrooms;
    }

    public int getPropertyBathrooms() {
        return propertyBathrooms;
    }

    public void setPropertyBathrooms(int propertyBathrooms) {
        this.propertyBathrooms = propertyBathrooms;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getProvincePrefix() {
        return provincePrefix;
    }

    public void setProvincePrefix(String provincePrefix) {
        this.provincePrefix = provincePrefix;
    }

    public String getDistrictPrefix() {
        return districtPrefix;
    }

    public void setDistrictPrefix(String districtPrefix) {
        this.districtPrefix = districtPrefix;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<String> getPropertyCoverPaths() {
        return propertyCoverPaths;
    }

    public void setPropertyCoverPaths(List<String> propertyCoverPaths) {
        this.propertyCoverPaths = propertyCoverPaths;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

 
}
