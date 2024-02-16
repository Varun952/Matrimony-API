package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserProfiles;
import com.appxbuild.matrimony.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserProfileRestController {

    private UserProfileService userProfileService;

    @Autowired
    public UserProfileRestController(UserProfileService theUserProfileService){
        userProfileService = theUserProfileService;
    }

    // expose "/user_profiles" and return a list of UserProfiles
    @GetMapping("/userprofiles")
    public List<UserProfiles> findAll() {
        return userProfileService.findAll();
    }

    // add mapping for Get "/user_profiles/{user_profileId}"
    @GetMapping("/userprofiles/{userprofilesId}")
    public UserProfiles getUserProfile(@PathVariable int userprofilesId){
        UserProfiles theUserProfiles = userProfileService.findById(userprofilesId);

        if(theUserProfiles == null){
            throw new RuntimeException("User Profile is not found" + userprofilesId);
        }
        return theUserProfiles;
    }

    // add mapping for POST "/user_profiles" - add new UserProfile
    @PostMapping("/userprofiles")
    public UserProfiles addUserProfile(@RequestBody UserProfiles theUserProfiles){
        theUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfiles.setCreated(localDateTime);
        theUserProfiles.setModified(null);
        UserProfiles newUserProfile = userProfileService.save(theUserProfiles);
        return newUserProfile;
    }

    // add mapping for PUT "/user_profiles" - update existing UserProfile
    @PutMapping("/userprofiles")
    public UserProfiles updateUserProfile(@RequestBody UserProfiles theUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfiles.setModified(localDateTime);
        UserProfiles newUserProfile = userProfileService.save(theUserProfiles);
        return newUserProfile;
    }

    // add mapping for DELETE "/user_profiles/{user_profileId}" - delete UserProfile
    @DeleteMapping("/userprofiles/{userprofilesId}")
    public String deleteUserProfile(@PathVariable int userprofilesId){
        UserProfiles theUserProfile = userProfileService.findById(userprofilesId);
        userProfileService.deleteById(userprofilesId);

        // throw exception if null
        if (theUserProfile == null){
            throw new RuntimeException("User Profile is not found - " + userprofilesId);
        }
        return "Deleted User Profile id - " + userprofilesId;
    }

}

