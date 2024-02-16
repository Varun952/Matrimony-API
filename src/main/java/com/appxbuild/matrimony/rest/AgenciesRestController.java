package com.appxbuild.matrimony
        .rest;

import com.appxbuild.matrimony.entity.Agencies;
import com.appxbuild.matrimony.service.AgenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgenciesRestController {

    private AgenciesService agenciesService;

    @Autowired
    public AgenciesRestController(AgenciesService agenciesService) {
        this.agenciesService = agenciesService;
    }


    @GetMapping("/agencies")
    public List<Agencies> findAll() {
        return agenciesService.findAll();
    }

    // add mapping for Get "/agencies/{agencyId}"
    @GetMapping("/agencies/{agencyId}")
    public Agencies getAgency(@PathVariable int agencyId){
        Agencies theAgency = agenciesService.findById(agencyId);
        if(theAgency == null){
            throw new RuntimeException("Agency is not found" + agencyId);
        }
        return theAgency;
    }

    //add mapping for POST "/agencies" - add new Agency
    @PostMapping("/agencies")
    public Agencies addAgency(@RequestBody Agencies theAgencies){
        theAgencies.setId(0);
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theAgencies.setCreated(timestamp);
        theAgencies.setModified(null);
        Agencies newAgency = agenciesService.save(theAgencies);
        return newAgency;
    }

    // add mapping for PUT "/agencies" - update existing Agency
    @PutMapping("/agencies")
    public Agencies updateAgency(@RequestBody Agencies theAgencies){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theAgencies.setModified(timestamp);
        Agencies newAgency = agenciesService.save(theAgencies);
        return newAgency;
    }

    // add mapping for DELETE "/agencies/{agencyId}" - delete Agency
    @DeleteMapping("/agencies/{agencyId}")
    public String deleteAgency(@PathVariable int agencyId){
        Agencies theAgency = agenciesService.findById(agencyId);
        agenciesService.deleteById(agencyId);
        // throw exception if null
        if (theAgency == null){
            throw new RuntimeException("Agency id is not found - " + agencyId);
        }
        return "Deleted Agency id - " + agencyId;
    }

}
