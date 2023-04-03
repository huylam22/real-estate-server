package com.devcamp.realestatebackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "property_address_number")
  private String propertyAddressNumber;

  @Column(name = "property_address_street")
  private String propertyAddressStreet;

  @Column(name = "property_area")
  private float propertyArea;

  @Column(name = "property_width")
  private float propertyWidth;

  @Column(name = "property_length")
  private int propertyLength;

  @Column(name = "property_floor_units")
  private int propertyFloorUnits;

  @Column(name = "property_floor_location")
  private String propertyFloorLocation;

  @Column(name = "property_bedrooms")
  private int propertyBedrooms;

  @Column(name = "property_bathrooms")
  private int propertyBathrooms;

  @Column(name = "property_price")
  private float propertyPrice;

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

  @ElementCollection
  @CollectionTable(
    name = "property_cover_paths",
    joinColumns = @JoinColumn(name = "property_id")
  )
  @Column(name = "cover_path")
  private List<String> propertyCoverPaths = new ArrayList<>();

  @Column(name = "created_date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDateTime createdDate;

  @ManyToOne
  @JoinColumn(name = "province_id")
  @JsonBackReference(value = "province-property")
  // @JsonProperty("provinceId")
  private Province province;

  @ManyToOne
  @JoinColumn(name = "district_id")
  @JsonBackReference(value = "district-property")
  // @JsonProperty("districtId")
  private District district;

  public Property() {}

  public Property(
    long id,
    String propertyAddressNumber,
    String propertyAddressStreet,
    float propertyArea,
    float propertyWidth,
    int propertyLength,
    int propertyFloorUnits,
    String propertyFloorLocation,
    int propertyBedrooms,
    int propertyBathrooms,
    float propertyPrice,
    String propertyLandType,
    String propertyLandDirection,
    String propertyLandLegalStatus,
    String propertyDescription,
    String propertyPostingStatus,
    List<String> propertyCoverPaths,
    LocalDateTime createdDate,
    Province province,
    District district
  ) {
    this.id = id;
    this.propertyAddressNumber = propertyAddressNumber;
    this.propertyAddressStreet = propertyAddressStreet;
    this.propertyArea = propertyArea;
    this.propertyWidth = propertyWidth;
    this.propertyLength = propertyLength;
    this.propertyFloorUnits = propertyFloorUnits;
    this.propertyFloorLocation = propertyFloorLocation;
    this.propertyBedrooms = propertyBedrooms;
    this.propertyBathrooms = propertyBathrooms;
    this.propertyPrice = propertyPrice;
    this.propertyLandType = propertyLandType;
    this.propertyLandDirection = propertyLandDirection;
    this.propertyLandLegalStatus = propertyLandLegalStatus;
    this.propertyDescription = propertyDescription;
    this.propertyPostingStatus = propertyPostingStatus;
    this.propertyCoverPaths = propertyCoverPaths;
    this.createdDate = createdDate;
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

  public int getPropertyLength() {
    return propertyLength;
  }

  public void setPropertyLength(int propertyLength) {
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
