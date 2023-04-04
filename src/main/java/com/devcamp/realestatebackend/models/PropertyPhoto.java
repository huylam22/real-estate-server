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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
