package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.BloodGroups;
import com.appxbuild.matrimony.service.BloodGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BloodGroupRestController {

    private BloodGroupService bloodGroupService;

    public BloodGroupRestController(BloodGroupService bloodGroupService) {
        this.bloodGroupService = bloodGroupService;
    }


    @GetMapping("bloodgroups")
    public List<BloodGroups> findAll() {
        return  bloodGroupService.findAll();
    }



    @GetMapping("/bloodgroups/{bloodgroupId}")
    public BloodGroups findById(@PathVariable int bloodgroupId ) {

        BloodGroups bloodGroups = bloodGroupService.findById(bloodgroupId);

        if (bloodGroups == null) {
            throw new RuntimeException("Users id not found - " + bloodgroupId);
        }

        return bloodGroups;
    }


}
