package com.yashesh.service;

import com.yashesh.entity.Country;
import com.yashesh.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

}
