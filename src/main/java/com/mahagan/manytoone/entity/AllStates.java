/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 20:56
 * Project: ManyToOneRelationalMappingWithHibernateSaveAndFetch
 **/

package com.mahagan.manytoone.entity;

import jakarta.persistence.*;

@Entity
@Table(name="states")
public class AllStates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String state_Name;
    private String state_code;
    private String population;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState_Name() {
        return state_Name;
    }

    public void setState_Name(String state_Name) {
        this.state_Name = state_Name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}


