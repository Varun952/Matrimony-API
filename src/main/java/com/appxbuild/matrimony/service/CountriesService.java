package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Countries;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountriesService {

    List<Countries> findAll();
    Countries findById(int theId);
    Countries save(Countries theCountries);
    void deleteById(int theId);
}
