package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.PhotosUserProfiles;
import com.appxbuild.matrimony.service.PhotosUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotoUserProfilesRestController {

    private PhotosUserProfilesService photosUserProfilesService;

    @Autowired
    public PhotoUserProfilesRestController(PhotosUserProfilesService thePhotosUserProfilesService){
        photosUserProfilesService = thePhotosUserProfilesService;
    }

    // expose "/photos_user_profiles" and return a list of Photo User Profiles
    @GetMapping("/photosuserprofiles")
    public List<PhotosUserProfiles> findAll(){
        return photosUserProfilesService.findAll();
    }

    // add mapping for GET /photos_user_profiles/{photos_user_profileId}
    @GetMapping("/photosuserprofiles/{photosuserprofilesId}")
    public PhotosUserProfiles getPhotoUserProfile(@PathVariable int photosuserprofilesId){
        PhotosUserProfiles thePhotosUserProfile = photosUserProfilesService.findById(photosuserprofilesId);
        if(thePhotosUserProfile == null){
            throw new RuntimeException("Photo User Profile id is not found " + photosuserprofilesId);
        }
        return thePhotosUserProfile;
    }

    // add mapping for POST /photos_user_profiles - add Photo User Profile
    @PostMapping("/photosuserprofiles")
    public PhotosUserProfiles addPhotoUserProfile(@RequestBody PhotosUserProfiles thePhotosUserProfiles){
        thePhotosUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotosUserProfiles.setCreated(localDateTime);
        thePhotosUserProfiles.setModified(localDateTime);
        PhotosUserProfiles newPhoto = photosUserProfilesService.save(thePhotosUserProfiles);
        return newPhoto;
    }

    // add mapping for PUT /photos_user_profiles - update existing Photo User Profile
    @PutMapping("/photos_user_profiles")
    public PhotosUserProfiles updatePhotoUserProfile(@RequestBody PhotosUserProfiles thePhotosUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotosUserProfiles.setModified(localDateTime);
        PhotosUserProfiles newPhoto = photosUserProfilesService.save(thePhotosUserProfiles);
        return newPhoto;
    }

    // add mapping for DELETE /photos_user_profiles/{photos_user_profileId} - delete Photo User Profile
    @DeleteMapping("/photosuserprofiles/{photosuserprofilesId}")
    public String deletePhotoUserProfile(@PathVariable int photosuserprofilesId){
        PhotosUserProfiles thePhotosUserProfile = photosUserProfilesService.findById(photosuserprofilesId);
        photosUserProfilesService.deleteById(photosuserprofilesId);

        // throw exception if null
        if (thePhotosUserProfile == null){
            throw new RuntimeException("Photo User Profile id is not found - " + photosuserprofilesId);
        }
        return "Deleted Photo User Profile id - " + photosuserprofilesId;
    }

 }
