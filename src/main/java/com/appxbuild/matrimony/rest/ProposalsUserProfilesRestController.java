package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.ProposalsUserProfiles;
import com.appxbuild.matrimony.service.ProposalsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProposalsUserProfilesRestController {

    private ProposalsUserProfilesService proposalsUserProfilesService;

    @Autowired
    public ProposalsUserProfilesRestController(ProposalsUserProfilesService proposalsUserProfilesService) {
        this.proposalsUserProfilesService = proposalsUserProfilesService;
    }

    @GetMapping("proposalsUserProfiles")
    public List<ProposalsUserProfiles> findAll() {
        return proposalsUserProfilesService.findAll();
    }
}
