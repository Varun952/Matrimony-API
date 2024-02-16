package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.PackageStatuses;
import com.appxbuild.matrimony.service.PackageStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PackageStatusesRestController {

    private PackageStatusesService packageStatusesService;

    @Autowired
    public PackageStatusesRestController(PackageStatusesService thePackageStatusesService){
        packageStatusesService = thePackageStatusesService;
    }

    // expose "/package_statuses" and return a list of types
    @GetMapping("/packagestatuses")
    public List<PackageStatuses> findAll(){
        return packageStatusesService.findAll();
    }

    // add mapping for GET /package_statuses/{package_statusId} to get a package status
    @GetMapping("/packagestatuses/{packagestatusesId}")
    public PackageStatuses getPackageStatus(@PathVariable int packagestatusesId){
        PackageStatuses  thePackageStatus= packageStatusesService.findById(packagestatusesId);
        if(thePackageStatus == null){
            throw new RuntimeException("package status id is not found " + packagestatusesId);
        }
        return thePackageStatus;
    }

    // add mapping for POST /package_statuses - add package status
    @PostMapping("/packagestatuses")
    public PackageStatuses addPackageStatus(@RequestBody PackageStatuses thepackageStatuses){
        thepackageStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thepackageStatuses.setCreated(localDateTime);
        thepackageStatuses.setModified(null);
        PackageStatuses newPackageStatus = packageStatusesService.save(thepackageStatuses);
        return newPackageStatus;
    }

    // add mapping for PUT /package_statuses - update existing packageStatus
    @PutMapping("/packagestatuses")
    public PackageStatuses updatePackageStatus(@RequestBody PackageStatuses thepackageStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        thepackageStatuses.setModified(localDateTime);
        PackageStatuses newPackageStatus = packageStatusesService.save(thepackageStatuses);
        return newPackageStatus;
    }

    // add mapping for DELETE /package_statuses/{relativeId} - delete packageStatus
    @DeleteMapping("/packagestatuses/{packagestatusesId}")
    public String deletePackageStatus(@PathVariable int packagestatusesId){
        PackageStatuses theType = packageStatusesService.findById(packagestatusesId);
        packageStatusesService.deleteById(packagestatusesId);

        // throw exception if null
        if (theType == null){
            throw new RuntimeException("Package Status id is not found - " + packagestatusesId);
        }
        return "Deleted Package Status id - " + packagestatusesId;
    }

 }
