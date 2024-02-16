package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.DegreeUserProfiles;
import com.appxbuild.matrimony.service.DegreeUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DegreeUserProfileRestController {

    private DegreeUserProfilesService degreeUserProfilesService;

    @Autowired
    public DegreeUserProfileRestController(DegreeUserProfilesService theDegreeUserProfilesService){
        degreeUserProfilesService = theDegreeUserProfilesService;
    }

    // expose GET "/degree_user_profiles" to get a list of degree user profiles
    @GetMapping("degreeuserprofiles")
    public List<DegreeUserProfiles> findALl(){
        return degreeUserProfilesService.findAll();
    }

    // add mapping for GET "/degree_user_profiles/{degree_user_profileId}"
    @GetMapping("/degreeuserprofiles/{degreeuserprofilesId}")
    public DegreeUserProfiles getDegreeUserProfile(@PathVariable int degreeuserprofilesId){
        DegreeUserProfiles theDegreeUserProfile = degreeUserProfilesService.findById(degreeuserprofilesId);
        if(theDegreeUserProfile == null){
            throw new RuntimeException("Degree User Profile id is not found " + degreeuserprofilesId);
        }
        return theDegreeUserProfile;
    }


    // add mapping for POST "/degreeuserprofiles" to add new degree user profile
    @PostMapping("/degreeuserprofiles")
    public DegreeUserProfiles addDegreeUserProfile(@RequestBody DegreeUserProfiles theDegreeUserProfiles){
        theDegreeUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theDegreeUserProfiles.setCreated(localDateTime);
        theDegreeUserProfiles.setModified(null);
        DegreeUserProfiles newDegreeUserProfile = degreeUserProfilesService.save(theDegreeUserProfiles);
        return newDegreeUserProfile;
    }

    // add mapping for PUT "/degree_user_profiles" to add new degree user profile
    @PutMapping("/degreeuserprofiles")
    public DegreeUserProfiles updateDegreeUserProfile(@RequestBody DegreeUserProfiles theDegreeUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theDegreeUserProfiles.setModified(localDateTime);
        DegreeUserProfiles newDegreeUserProfile = degreeUserProfilesService.save(theDegreeUserProfiles);
        return newDegreeUserProfile;
    }

    // add mapping for DELETE "/degree_user_profiles/{degree_user_profileId}" to delete degree user profile
    @DeleteMapping("/degreeuserprofiles/{degreeuserprofilesId}")
    public String deleteDegreeUserProfile(@PathVariable int degreeuserprofilesId){
        DegreeUserProfiles theDegreeUserProfile = degreeUserProfilesService.findById(degreeuserprofilesId);
        degreeUserProfilesService.deleteById(degreeuserprofilesId);
        if(theDegreeUserProfile == null){
            throw new RuntimeException("Degree User Profile id is not found " + degreeuserprofilesId);
        }
        return "Deleted Degree User Profile id " + degreeuserprofilesId;
    }
}
