package com.devcamp.realestatebackend.services.DTO;

import com.devcamp.realestatebackend.models.Property;

public class PropertyDTO {
    private long id;
    private String propertyAddressNumber;
    private String propertyAddressStreet;
    private String propertyArea;
    private String propertyWidth;
    private String propertyLength;
    private String propertyFloorUnits;
    private String propertyFloorLocation;
    private String propertyPrice;
    private String propertyLandType;
    private String propertyLandDirection;
    private String propertyLandLegalStatus;
    private String propertyDescription;
    private String propertyPostingStatus;
    private int provinceId;
    private int districtId;
    private String provincePrefix;
    private String districtPrefix;
    
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
        this.districtPrefix = property.getDistrict().getDistrictPrefix();
    }

    public PropertyDTO() {
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

    public String getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(String propertyArea) {
        this.propertyArea = propertyArea;
    }

    public String getPropertyWidth() {
        return propertyWidth;
    }

    public void setPropertyWidth(String propertyWidth) {
        this.propertyWidth = propertyWidth;
    }

    public String getPropertyLength() {
        return propertyLength;
    }

    public void setPropertyLength(String propertyLength) {
        this.propertyLength = propertyLength;
    }

    public String getPropertyFloorUnits() {
        return propertyFloorUnits;
    }

    public void setPropertyFloorUnits(String propertyFloorUnits) {
        this.propertyFloorUnits = propertyFloorUnits;
    }

    public String getPropertyFloorLocation() {
        return propertyFloorLocation;
    }

    public void setPropertyFloorLocation(String propertyFloorLocation) {
        this.propertyFloorLocation = propertyFloorLocation;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
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
    
    // getters and setters omitted for brevity
    
}
