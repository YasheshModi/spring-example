package com.yashesh.entity;

import javax.persistence.*;

@Entity
@Table(name = "countrylist")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private long id;

    @Column(name = "country")
    private String country;

    public Country() {

    }

    public Country(String country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}