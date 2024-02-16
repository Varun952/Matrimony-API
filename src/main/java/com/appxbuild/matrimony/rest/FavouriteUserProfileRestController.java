package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FavouriteUserProfile;
import com.appxbuild.matrimony.service.FavouriteUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FavouriteUserProfileRestController {

    private FavouriteUserProfileService favouriteUserProfilesService;

    @Autowired
    public FavouriteUserProfileRestController(FavouriteUserProfileService theFavouriteUserProfilesService){
        favouriteUserProfilesService = theFavouriteUserProfilesService;
    }

    // expose "/favourites_user_profiles" and return a list of favourite User Profiles
    @GetMapping("/favouritesuserprofiles")
    public List<FavouriteUserProfile> findAll() {
        return favouriteUserProfilesService.findAll();
    }

    // add mapping for Get "/favourites_user_profiles/{favourites_user_profilesId}"
    @GetMapping("/favouritesuserprofiles/{favouritesuserprofilesId}")
    public FavouriteUserProfile getFavouriteUserProfile(@PathVariable int favouritesuserprofilesId){
        FavouriteUserProfile theFavouriteUserProfile = favouriteUserProfilesService.findById(favouritesuserprofilesId);

        if(theFavouriteUserProfile == null){
            throw new RuntimeException("Favourite is not found" + favouritesuserprofilesId);
        }
        return theFavouriteUserProfile;
    }

    // add mapping for POST "/favourites_user_profiles" - add new favourite User Profile
    @PostMapping("/favouritesuserprofiles")
    public FavouriteUserProfile addFavouriteUserProfile(@RequestBody FavouriteUserProfile theFavouriteUserProfile){
        theFavouriteUserProfile.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavouriteUserProfile.setCreated(localDateTime);
        theFavouriteUserProfile.setModified(null);
        FavouriteUserProfile newFavouriteUserProfile = favouriteUserProfilesService.save(theFavouriteUserProfile);
        return newFavouriteUserProfile;
    }

    // add mapping for PUT "/favourites_user_profiles" - update existing favourite User Profile
    @PutMapping("/favouritesuserprofiles")
    public FavouriteUserProfile updateFavouriteUserProfile(@RequestBody FavouriteUserProfile theFavouriteUserProfile){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavouriteUserProfile.setModified(localDateTime);
        FavouriteUserProfile newFavouriteUserProfile = favouriteUserProfilesService.save(theFavouriteUserProfile);
        return newFavouriteUserProfile;
    }

    // add mapping for DELETE "/favourites_user_profiles/{favourites_user_profilesId}" - delete favourite User Profile
    @DeleteMapping("/favouritesuserprofiles/{favouritesuserprofilesId}")
    public String deleteFavouriteUserProfile(@PathVariable int favouritesuserprofilesId){
        FavouriteUserProfile theFavouriteUserProfile = favouriteUserProfilesService.findById(favouritesuserprofilesId);
        favouriteUserProfilesService.deleteById(favouritesuserprofilesId);

        // throw exception if null
        if (theFavouriteUserProfile == null){
            throw new RuntimeException("Favourite User Profile id is not found - " + favouritesuserprofilesId);
        }
        return "Deleted Favourite User Profile id - " + favouritesuserprofilesId;
    }

}

