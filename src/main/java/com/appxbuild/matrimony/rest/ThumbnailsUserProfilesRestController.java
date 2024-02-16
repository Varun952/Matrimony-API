package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.ThumbnailsUserProfiles;
import com.appxbuild.matrimony.service.ThumbnailsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ThumbnailsUserProfilesRestController {

    private ThumbnailsUserProfilesService thumbnailsUserProfilesService;

    @Autowired
    public ThumbnailsUserProfilesRestController(ThumbnailsUserProfilesService theThumbnailsUserProfilesService){
        thumbnailsUserProfilesService = theThumbnailsUserProfilesService;
    }

    // expose "/thumbnails_user_profiles" and return a list of Thumbnail User Profiles
    @GetMapping("/thumbnailsuserprofiles")
    public List<ThumbnailsUserProfiles> findAll(){
        return thumbnailsUserProfilesService.findAll();
    }

    // add mapping for GET "/thumbnails_user_profiles/{thumbnailId}"
    @GetMapping("/thumbnailsuserprofiles/{thumbnailsuserprofilesId}")
    public ThumbnailsUserProfiles getThumbnailUserProfile(@PathVariable int thumbnailsuserprofilesId){
        ThumbnailsUserProfiles theThumbnailsUserProfile = thumbnailsUserProfilesService.findById(thumbnailsuserprofilesId);
        if(theThumbnailsUserProfile == null){
            throw new RuntimeException("Thumbnail User Profile id is not found " + thumbnailsuserprofilesId);
        }
        return theThumbnailsUserProfile;
    }

    // add mapping for POST "/thumbnails_user_profiles" - add Thumbnail User Profile
    @PostMapping("/thumbnailsuserprofiles")
    public ThumbnailsUserProfiles addThumbnailUserProfile(@RequestBody ThumbnailsUserProfiles theThumbnailsUserProfiles){
        theThumbnailsUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnailsUserProfiles.setCreated(localDateTime);
        theThumbnailsUserProfiles.setModified(localDateTime);
        ThumbnailsUserProfiles newThumbnail = thumbnailsUserProfilesService.save(theThumbnailsUserProfiles);
        return newThumbnail;
    }

    // add mapping for PUT "/thumbnails_user_profiles" - update existing Thumbnail User Profile
    @PutMapping("/thumbnailsuserprofiles")
    public ThumbnailsUserProfiles updateThumbnailUserProfile(@RequestBody ThumbnailsUserProfiles theThumbnailsUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnailsUserProfiles.setModified(localDateTime);
        ThumbnailsUserProfiles newThumbnail = thumbnailsUserProfilesService.save(theThumbnailsUserProfiles);
        return newThumbnail;
    }

    // add mapping for DELETE "/thumbnails/{thumbnails_user_profileId}" - delete Thumbnail User Profile
    @DeleteMapping("/thumbnailsuserprofiles/{thumbnailsuserprofilesId}")
    public String deleteThumbnailUserProfile(@PathVariable int thumbnailsuserprofilesId){
        ThumbnailsUserProfiles theThumbnailsUserProfile = thumbnailsUserProfilesService.findById(thumbnailsuserprofilesId);
        thumbnailsUserProfilesService.deleteById(thumbnailsuserprofilesId);

        // throw exception if null
        if (theThumbnailsUserProfile == null){
            throw new RuntimeException("Thumbnail User Profile id is not found - " + thumbnailsuserprofilesId);
        }
        return "Deleted Thumbnail User Profile id - " + thumbnailsuserprofilesId;
    }

 }
