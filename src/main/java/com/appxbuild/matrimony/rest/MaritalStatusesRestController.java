package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MaritalStatuses;
import com.appxbuild.matrimony.service.MaritalStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaritalStatusesRestController {

    private MaritalStatusesService maritalStatusesService;

    @Autowired
    public MaritalStatusesRestController(MaritalStatusesService theMaritalStatusesService){
        maritalStatusesService = theMaritalStatusesService;
    }

    // expose "/marital_statuses" and return a list of marital statuses
    @GetMapping("/maritalstatuses")
    public List<MaritalStatuses> findAll(){
        return maritalStatusesService.findAll();
    }


}
