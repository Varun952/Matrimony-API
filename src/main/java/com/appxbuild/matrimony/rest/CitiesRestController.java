package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Cities;
import com.appxbuild.matrimony.service.CitiesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CitiesRestController {

    private CitiesService citiesService;

    public CitiesRestController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/cities")
    public List<Cities> findAll() {
        return citiesService.findAll();
    }

    @GetMapping("/cities/{citiesId}")
    public Cities findById(@PathVariable int citiesId ) {

        Cities cities = citiesService.findById(citiesId);

        if (cities == null) {
            throw new RuntimeException("cities id not found - " + citiesId);
        }

        return cities;
    }

}
