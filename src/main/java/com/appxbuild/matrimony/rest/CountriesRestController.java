package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Countries;
import com.appxbuild.matrimony.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountriesRestController {

    private CountriesService countriesService;

    @Autowired
    public CountriesRestController(CountriesService theCountriesService){
        countriesService = theCountriesService;
    }

    // expose GET "/countries" to get a list of countries
    @GetMapping("/countries")
    public List<Countries> findAll(){
        return countriesService.findAll();
    }
}
