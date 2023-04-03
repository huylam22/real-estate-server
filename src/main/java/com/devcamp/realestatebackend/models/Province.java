package com.devcamp.realestatebackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provinces")
public class Province {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "code")
  private String provinceCode;

  @Column(name = "name")
  private String provinceName;

  @OneToMany(
    targetEntity = District.class,
    mappedBy = "province",
    cascade = CascadeType.ALL
  )
  @JsonManagedReference(value = "province-district")
  // @JsonIgnore
  private Set<District> districts;

  @OneToMany(
    targetEntity = Property.class,
    mappedBy = "province",
    cascade = CascadeType.ALL
  )
  @JsonManagedReference(value = "province-property")
  // @JsonIgnore
  private Set<Property> properties;

  public Province() {}

  public Province(
    int id,
    String provinceCode,
    String provinceName,
    Set<District> districts,
    Set<Property> properties
  ) {
    this.id = id;
    this.provinceCode = provinceCode;
    this.provinceName = provinceName;
    this.districts = districts;
    this.properties = properties;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public Set<District> getDistricts() {
    return districts;
  }

  public void setDistricts(Set<District> districts) {
    this.districts = districts;
  }

  public Set<Property> getProperties() {
    return properties;
  }

  public void setProperties(Set<Property> properties) {
    this.properties = properties;
  }
}
