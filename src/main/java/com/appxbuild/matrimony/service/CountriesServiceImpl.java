package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.CountriesDAO;
import com.appxbuild.matrimony.entity.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesServiceImpl implements CountriesService{

    private CountriesDAO countriesDAO;

    @Autowired
    public CountriesServiceImpl(CountriesDAO theCountriesDAO){
        countriesDAO = theCountriesDAO;
    }

    @Override
    public List<Countries> findAll() {
        return countriesDAO.findAll();
    }

    @Override
    public Countries findById(int theId) {
        Optional<Countries> result = countriesDAO.findById(theId);
        Countries theCountries = null;
        if (result.isPresent()){
            theCountries = result.get();
        }
        else {
            throw new RuntimeException("Country id is not found " + theId);
        }
        return theCountries;
    }

    @Override
    public Countries save(Countries theCountries) {
        return countriesDAO.save(theCountries);
    }

    @Override
    public void deleteById(int theId) {
        countriesDAO.deleteById(theId);
    }
}
