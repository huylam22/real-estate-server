package com.devcamp.realestatebackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "districts")
public class District {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String districtName;

  @Column(name = "prefix")
  private String districtPrefix;

  @ManyToOne
  @JsonBackReference(value = "province-district")
  @JoinColumn(name = "province_id")
  private Province province;

  @OneToMany(targetEntity = Property.class, mappedBy = "district")
  @JsonManagedReference(value = "district-property")
  // @JsonIgnore
  private Set<Property> properties;

  @OneToMany(targetEntity = Ward.class, mappedBy = "district")
  @JsonManagedReference(value = "district-ward")
  private Set<Ward> wards;
}
