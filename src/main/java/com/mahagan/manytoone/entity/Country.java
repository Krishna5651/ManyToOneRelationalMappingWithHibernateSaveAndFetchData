/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 20:55
 * Project: ManyToOneRelationalMappingWithHibernateSaveAndFetch
 **/

package com.mahagan.manytoone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int country_Id;
    private String country_Name;
    private String Continent;

    public int getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(int country_Id) {
        this.country_Id = country_Id;
    }

    public String getCountry_Name() {
        return country_Name;
    }

    public void setCountry_Name(String country_Name) {
        this.country_Name = country_Name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

}


