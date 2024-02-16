package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.CitiesDAO;
import com.appxbuild.matrimony.entity.Cities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesServiceaImpl implements CitiesService {

    private CitiesDAO citiesDAO;

    public CitiesServiceaImpl(CitiesDAO citiesDAO) {
        this.citiesDAO = citiesDAO;
    }


    @Override
    public List<Cities> findAll() {
        return citiesDAO.findAll();
    }

    @Override
    public Cities findById(int theId) {

        Optional<Cities> result = citiesDAO.findById(theId);

        Cities cities = null;

        if(result.isPresent()) {
            cities = result.get();
        }
        else {
            throw  new RuntimeException("cities id not found "+ theId);
        }


        return cities;
    }
}
