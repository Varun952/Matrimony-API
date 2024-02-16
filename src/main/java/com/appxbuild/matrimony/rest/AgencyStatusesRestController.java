package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AgencyStatuses;
import com.appxbuild.matrimony.service.AgencyStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgencyStatusesRestController {

    private AgencyStatusesService agencyStatusesService;

    @Autowired
    public AgencyStatusesRestController(AgencyStatusesService theAgencyStatusesService){
        agencyStatusesService = theAgencyStatusesService;
    }

    // expose "/agencystatuses" and return a list of Agency Status
    @GetMapping("/agencystatuses")
    public List<AgencyStatuses> findAll(){
        return agencyStatusesService.findAll();
    }

    // add mapping for Get "/agency_statuses/{agency_statusId}"
    @GetMapping("/agencystatuses/{agencystatusesId}")
    public AgencyStatuses getAgencyStatuses(@PathVariable int agencystatusesId){
        AgencyStatuses theAgencyStatuses = agencyStatusesService.findById(agencystatusesId);

        if(theAgencyStatuses == null){
            throw new RuntimeException("Agency Status is not found" + agencystatusesId);
        }
        return theAgencyStatuses;
    }

    //add mapping for POST "/agencystatuses" - add new Agency Status
    @PostMapping("/agencystatuses")
    public AgencyStatuses addAgencyStatus(@RequestBody AgencyStatuses theAgencyStatuses){
        theAgencyStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theAgencyStatuses.setCreated(localDateTime);
        theAgencyStatuses.setModified(null);
        AgencyStatuses newAgencyStatus = agencyStatusesService.save(theAgencyStatuses);
        return newAgencyStatus;
    }

    // add mapping for PUT "/agencystatuses" - update existing AgencyStatus
    @PutMapping("/agencystatuses")
    public AgencyStatuses updateAgencyStatus(@RequestBody AgencyStatuses theAgencyStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theAgencyStatuses.setModified(localDateTime);
        AgencyStatuses newAgencyStatus = agencyStatusesService.save(theAgencyStatuses);
        return newAgencyStatus;
    }

    // add mapping for DELETE ""/agencystatuses/{agencystatusesId}"- delete AgencyStatus
    @DeleteMapping("/agencystatuses/{agencystatusesId}")
    public String deleteAgencyStatus(@PathVariable int agencystatusesId){
        AgencyStatuses theAgencyStatus = agencyStatusesService.findById(agencystatusesId);
        agencyStatusesService.deleteById(agencystatusesId);

        // throw exception if null
        if (theAgencyStatus == null){
            throw new RuntimeException("Agency Status id is not found - " + agencystatusesId);
        }
        return "Deleted Agency Status id - " + agencystatusesId;
    }
}
