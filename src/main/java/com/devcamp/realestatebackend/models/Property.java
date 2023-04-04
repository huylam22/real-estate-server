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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
