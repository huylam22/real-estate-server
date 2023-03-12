package com.devcamp.realestatebackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name =  "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "property_address_number")
    private String propertyAddressNumber;

    @Column(name = "property_address_street")
    private String propertyAddressStreet;

    @Column(name = "property_area")
    private String propertyArea;

    @Column(name = "property_width")
    private String propertyWidth;

    @Column(name = "property_length")
    private String propertyLength;

    @Column(name = "property_floor_units")
    private String propertyFloorUnits;

    @Column(name = "property_floor_location")
    private String propertyFloorLocation;

    @Column(name = "property_price")
    private String propertyPrice;

    @Column(name = "property_land_type")
    private String propertyLandType;

    @Column(name = "property_land_direction")
    private String propertyLandDirection;

    @Column(name = "property_land_legal_status")
    private String propertyLandLegalStatus;

    @Column(name = "property_description")
    private String propertyDescription;

    @Column(name = "property_posting_status")
    private String propertyPostingStatus;

    @ManyToOne
    @JoinColumn(name="province_id")
    @JsonBackReference(value="province-property")
    // @JsonProperty("provinceId")
    private Province province;

    @ManyToOne
    @JoinColumn(name="district_id")
    @JsonBackReference(value="district-property")
    // @JsonProperty("districtId")
    private District district;

    public Property() {
    }

    public Property(long id, String propertyAddressNumber, String propertyAddressStreet, String propertyArea,
            String propertyWidth, String propertyLength, String propertyFloorUnits, String propertyFloorLocation,
            String propertyPrice, String propertyLandType, String propertyLandDirection, String propertyLandLegalStatus,
            String propertyDescription, String propertyPostingStatus, Province province, District district) {
        this.id = id;
        this.propertyAddressNumber = propertyAddressNumber;
        this.propertyAddressStreet = propertyAddressStreet;
        this.propertyArea = propertyArea;
        this.propertyWidth = propertyWidth;
        this.propertyLength = propertyLength;
        this.propertyFloorUnits = propertyFloorUnits;
        this.propertyFloorLocation = propertyFloorLocation;
        this.propertyPrice = propertyPrice;
        this.propertyLandType = propertyLandType;
        this.propertyLandDirection = propertyLandDirection;
        this.propertyLandLegalStatus = propertyLandLegalStatus;
        this.propertyDescription = propertyDescription;
        this.propertyPostingStatus = propertyPostingStatus;
        this.province = province;
        this.district = district;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }


}