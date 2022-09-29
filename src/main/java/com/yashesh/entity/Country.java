package com.yashesh.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
//    private List<Teacher> teacherList = new ArrayList<>();

    public Country() {

    }

    public Country(String country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}