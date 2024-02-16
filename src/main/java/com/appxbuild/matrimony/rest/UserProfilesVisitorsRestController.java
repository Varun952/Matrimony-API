package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserProfilesVisitors;
import com.appxbuild.matrimony.service.UserProfilesVisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserProfilesVisitorsRestController {

    private UserProfilesVisitorsService userProfilesVisitorsService;

    @Autowired
    public UserProfilesVisitorsRestController(UserProfilesVisitorsService theUserProfilesVisitorsService){
        userProfilesVisitorsService = theUserProfilesVisitorsService;
    }

    // expose "/user_profiles_visitors" and return a list of UserProfileVisitors
    @GetMapping("/userprofilesvisitors")
    public List<UserProfilesVisitors> findAll() {
        return userProfilesVisitorsService.findAll();
    }

    // add mapping for Get "/user_profiles_visitors/{user_profiles_visitorId}"
    @GetMapping("/userprofilesvisitors/{userprofilesvisitorsId}")
    public UserProfilesVisitors getUserProfileVisitor(@PathVariable int userprofilesvisitorsId){
        UserProfilesVisitors theUserProfilesVisitor = userProfilesVisitorsService.findById(userprofilesvisitorsId);

        if(theUserProfilesVisitor == null){
            throw new RuntimeException("User Profile Visitor is not found" + userprofilesvisitorsId);
        }
        return theUserProfilesVisitor;
    }

    // add mapping for POST "/user_profiles_visitors" - add new UserProfileVisitor
    @PostMapping("/userprofilesvisitors")
    public UserProfilesVisitors addUserProfileVisitor(@RequestBody UserProfilesVisitors theUserProfilesVisitors){
        theUserProfilesVisitors.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfilesVisitors.setCreated(localDateTime);
        theUserProfilesVisitors.setModified(null);
        UserProfilesVisitors newUserProfile = userProfilesVisitorsService.save(theUserProfilesVisitors);
        return newUserProfile;
    }

    // add mapping for PUT "/user_profiles_visitors" - update existing UserProfileVisitor
    @PutMapping("/userprofilesvisitors")
    public UserProfilesVisitors updateUserProfileVisitor(@RequestBody UserProfilesVisitors theUserProfilesVisitors){
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfilesVisitors.setModified(localDateTime);
        UserProfilesVisitors newUserProfile = userProfilesVisitorsService.save(theUserProfilesVisitors);
        return newUserProfile;
    }

    // add mapping for DELETE "/user_profiles_visitors/{user_profiles_visitorId}" - delete UserProfileVisitor
    @DeleteMapping("/userprofilesvisitors/{userprofilesvisitorsId}")
    public String deleteUserProfileVisitor(@PathVariable int userprofilesvisitorsId){
        UserProfilesVisitors theUserProfilesVisitor = userProfilesVisitorsService.findById(userprofilesvisitorsId);
        userProfilesVisitorsService.deleteById(userprofilesvisitorsId);

        // throw exception if null
        if (theUserProfilesVisitor == null){
            throw new RuntimeException("User Profile Visitor is not found - " + userprofilesvisitorsId);
        }
        return "Deleted User Profile Visitor id - " + userprofilesvisitorsId;
    }

}

