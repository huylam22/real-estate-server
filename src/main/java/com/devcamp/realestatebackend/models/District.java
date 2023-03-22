package com.devcamp.realestatebackend.models;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
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
    @JsonBackReference(value="province-district")
    @JoinColumn(name="province_id")
    private Province province;

    @OneToMany(targetEntity = Property.class, mappedBy = "district")
    @JsonManagedReference(value="district-property")
    // @JsonIgnore
    private Set<Property> properties; 

    @OneToMany(targetEntity = Ward.class, mappedBy = "district")
    @JsonManagedReference(value="district-ward")
    private Set<Ward> wards;

    public District() {
    }

    public District(int id, String districtName, String districtPrefix, Province province, Set<Property> properties,
            Set<Ward> wards) {
        this.id = id;
        this.districtName = districtName;
        this.districtPrefix = districtPrefix;
        this.province = province;
        this.properties = properties;
        this.wards = wards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictPrefix() {
        return districtPrefix;
    }

    public void setDistrictPrefix(String districtPrefix) {
        this.districtPrefix = districtPrefix;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<Ward> getWards() {
        return wards;
    }

    public void setWards(Set<Ward> wards) {
        this.wards = wards;
    } 

}
