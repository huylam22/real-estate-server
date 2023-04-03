package com.devcamp.realestatebackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_photos")
public class PropertyPhoto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long propertyPhotoId;

  @Column(name = "photo_name")
  private String propertyPhotoName;

  @Column(name = "photo_url")
  private String propertyPhotoUrl; // THE S3 KEY

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "property_id")
  private Property property;

  public PropertyPhoto() {}

  public PropertyPhoto(
    Long propertyPhotoId,
    String propertyPhotoName,
    String propertyPhotoUrl,
    Property property
  ) {
    this.propertyPhotoId = propertyPhotoId;
    this.propertyPhotoName = propertyPhotoName;
    this.propertyPhotoUrl = propertyPhotoUrl;
    this.property = property;
  }

  public Long getPropertyPhotoId() {
    return propertyPhotoId;
  }

  public void setPropertyPhotoId(Long propertyPhotoId) {
    this.propertyPhotoId = propertyPhotoId;
  }

  public String getPropertyPhotoName() {
    return propertyPhotoName;
  }

  public void setPropertyPhotoName(String propertyPhotoName) {
    this.propertyPhotoName = propertyPhotoName;
  }

  public String getPropertyPhotoUrl() {
    return propertyPhotoUrl;
  }

  public void setPropertyPhotoUrl(String propertyPhotoUrl) {
    this.propertyPhotoUrl = propertyPhotoUrl;
  }

  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
  }
}
