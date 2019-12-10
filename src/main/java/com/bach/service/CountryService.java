package com.bach.service;

import com.bach.models.Country;

public interface CountryService {
    Iterable<Country> findAll();
    Country findById(Long countryId);
    void save(Country country);
    void remove(Long countryId);
}
