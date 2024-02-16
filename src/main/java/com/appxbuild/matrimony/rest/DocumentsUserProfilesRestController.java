package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.DocumentsUserProfiles;
import com.appxbuild.matrimony.service.DocumentsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentsUserProfilesRestController {

    private DocumentsUserProfilesService documentsUserProfilesService;

    @Autowired
    public DocumentsUserProfilesRestController(DocumentsUserProfilesService theDocumentsUserProfilesService){
        documentsUserProfilesService = theDocumentsUserProfilesService;
    }

    // expose GET "/documents_user_profiles" to get a list of Documents User Profiles
    @GetMapping("/documentsuserprofiles")
    public List<DocumentsUserProfiles> findAll(){
        return documentsUserProfilesService.findAll();
    }

    // add mapping for GET "/documents_user_profiles/{documents_user_profileId}" to get Document User Profile
    @GetMapping("/documentsuserprofiles/{documentsuserprofilesId}")
    public DocumentsUserProfiles getDocumentUserProfile(@PathVariable int documentsuserprofilesId){
        DocumentsUserProfiles theDocumentsUserProfile = documentsUserProfilesService.findById(documentsuserprofilesId);
        if(theDocumentsUserProfile == null){
            throw  new RuntimeException("Document User Profile id is not found " + documentsuserprofilesId);
        }
        return theDocumentsUserProfile;
    }

    // add mapping for POST "/documents_user_profiles" to add a new Document User Profile
    @PostMapping("/documentsuserprofiles")
    private DocumentsUserProfiles addDocumentUserProfile(@RequestBody DocumentsUserProfiles theDocumentsUserProfiles){
        theDocumentsUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocumentsUserProfiles.setCreated(localDateTime);
        theDocumentsUserProfiles.setModified(null);
        DocumentsUserProfiles newDocumentsUserProfile = documentsUserProfilesService.save(theDocumentsUserProfiles);
         return newDocumentsUserProfile;
    }

    // add mapping for PUT "/documents_user_profiles" to update Document User Profile
    @PutMapping("/documentsuserprofiles")
    private DocumentsUserProfiles updateDocumentUserProfile(@RequestBody DocumentsUserProfiles theDocumentsUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocumentsUserProfiles.setModified(localDateTime);
        DocumentsUserProfiles newDocumentsUserProfile = documentsUserProfilesService.save(theDocumentsUserProfiles);
        return newDocumentsUserProfile;
    }

    // add mapping for DELETE "/documents_user_profiles/{documents_user_profileId}" to delete Document User Profile
    @DeleteMapping("/documentsuserprofiles/{documentsuserprofilesId}")
    private String deleteDocumentUserProfile(@PathVariable int documentsuserprofilesId){
        DocumentsUserProfiles theDocumentsUserProfile = documentsUserProfilesService.findById(documentsuserprofilesId);
        documentsUserProfilesService.deleteById(documentsuserprofilesId);
        if (theDocumentsUserProfile == null){
            throw new RuntimeException("Document User Profile id id not found " + documentsuserprofilesId);
        }
        return "Deleted Document User Profile Id " + documentsuserprofilesId;
    }
}
