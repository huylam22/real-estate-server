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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
