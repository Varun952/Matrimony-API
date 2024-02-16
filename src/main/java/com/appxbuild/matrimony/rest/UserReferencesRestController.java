package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserReferences;
import com.appxbuild.matrimony.service.UserReferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserReferencesRestController {

    private UserReferencesService userReferencesService;

    @Autowired
    public UserReferencesRestController(UserReferencesService theUserReferencesService) {
        userReferencesService = theUserReferencesService;
    }

    // expose "/user_references" and return a list of userReferences
    @GetMapping("/userreferences")
    public List<UserReferences> findAll() {
        return userReferencesService.findAll();
    }

    // add mapping for GET /references/{referenceId}
    @GetMapping("/userreferences/{userreferencesId}")
    public UserReferences getUserReferences(@PathVariable int userreferencesId) {
        UserReferences theUserReferences = userReferencesService.findById(userreferencesId);
        if (theUserReferences == null) {
            throw new RuntimeException("User Reference is not found " + userreferencesId);
        }
        return theUserReferences;
    }

    // add mapping for POST /user_references - add new userReferences
    @PostMapping("/userreferences")
    public UserReferences addUserReferences(@RequestBody UserReferences theUserReferences) {
        theUserReferences.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserReferences.setCreated(localDateTime);
        theUserReferences.setModified(null);
        UserReferences newUserReference = userReferencesService.save(theUserReferences);
        return newUserReference;
    }

    // add mapping for PUT /user_references - update existing UserReferences
    @PutMapping("/user_references")
    public UserReferences updateUserReferences(@RequestBody UserReferences theUserReference) {
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserReference.setModified(localDateTime);
        UserReferences newUserReference = userReferencesService.save(theUserReference);
        return newUserReference;
    }

    // delete mapping for DELETE /references/{referenceId}
    @DeleteMapping("/userreferences/{userreferencesId}")
    public String deleteUserReference(@PathVariable int userreferencesId){
        UserReferences theUserReferences = userReferencesService.findById(userreferencesId);

        // throw exception if null
        if(theUserReferences == null){
            throw new RuntimeException("User Reference is not found - " + userreferencesId);
        }
        userReferencesService.deleteById(userreferencesId);
        return "Deleted User id - " + userreferencesId;
    }
}