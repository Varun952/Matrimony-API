package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FriendsUserProfiles;
import com.appxbuild.matrimony.service.FriendsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FriendsUserProfilesRestController {

    private FriendsUserProfilesService friendsUserProfilesService;

    @Autowired
    public FriendsUserProfilesRestController(FriendsUserProfilesService theFriendsUserProfilesService){
        friendsUserProfilesService = theFriendsUserProfilesService;
    }

    // expose "/friends_user_profiles" and return a list of Friend User Profiles
    @GetMapping("/friendsuserprofiles")
    public List<FriendsUserProfiles> findAll() {
        return friendsUserProfilesService.findAll();
    }

    // add mapping for Get "/friends_user_profiles/{friends_user_profileId}"
    @GetMapping("/friendsuserprofiles/{friendsuserprofilesId}")
    public FriendsUserProfiles getFriendUserProfile(@PathVariable int friendsuserprofilesId){
        FriendsUserProfiles theFriendUserProfile = friendsUserProfilesService.findById(friendsuserprofilesId);

        if(theFriendUserProfile == null){
            throw new RuntimeException("Friend User Profile id is not found" + friendsuserprofilesId);
        }
        return theFriendUserProfile;
    }

    // add mapping for POST "/friends_user_profiles" - add new list of Friend User Profile
    @PostMapping("/friendsuserprofiles")
    public FriendsUserProfiles addFriendUserProfile(@RequestBody FriendsUserProfiles theFriendUserProfiles){
        theFriendUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriendUserProfiles.setCreated(localDateTime);
        theFriendUserProfiles.setModified(null);
        FriendsUserProfiles newFriendUserProfile = friendsUserProfilesService.save(theFriendUserProfiles);
        return newFriendUserProfile;
    }

    // add mapping for PUT "/friends_user_profiles" - update existing list of Friend User Profile
    @PutMapping("/friendsuserprofiles")
    public FriendsUserProfiles updateFriendUserProfile(@RequestBody FriendsUserProfiles theFriendUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriendUserProfiles.setModified(localDateTime);
        FriendsUserProfiles newFriendUserProfile = friendsUserProfilesService.save(theFriendUserProfiles);
        return newFriendUserProfile;
    }

    // add mapping for DELETE "/friends_user_profiles/{friends_user_profileId}" - delete list of Friend User Profile
    @DeleteMapping("/friendsuserprofiles/{friendsuserprofilesId}")
    public String deleteFriendUserProfile(@PathVariable int friendsuserprofilesId){
        FriendsUserProfiles theFriendUserProfile = friendsUserProfilesService.findById(friendsuserprofilesId);
        friendsUserProfilesService.deleteById(friendsuserprofilesId);

        // throw exception if null
        if (theFriendUserProfile == null){
            throw new RuntimeException("Friend User Profile id is not found - " + friendsuserprofilesId);
        }
        return "Deleted Friend User Profile id - " + friendsuserprofilesId;
    }

}

