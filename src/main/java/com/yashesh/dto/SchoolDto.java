package com.yashesh.dto;

import com.yashesh.entity.Country;

public class SchoolDto {

    private String name;

    public SchoolDto() {

    }

    public SchoolDto(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
