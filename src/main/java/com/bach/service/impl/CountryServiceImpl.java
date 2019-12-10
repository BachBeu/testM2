package com.bach.service.impl;

import com.bach.models.Country;
import com.bach.repository.CountryRepository;
import com.bach.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long countryId) {
        return countryRepository.findOne(countryId);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long countryId) {
        countryRepository.delete(countryId);
    }
}
