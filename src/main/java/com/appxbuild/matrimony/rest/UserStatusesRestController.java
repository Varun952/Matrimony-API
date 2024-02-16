package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserStatuses;
import com.appxbuild.matrimony.service.UserStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserStatusesRestController {

    private UserStatusesService userStatusesService;

    @Autowired
    public UserStatusesRestController(UserStatusesService theUserStatusesService){
        userStatusesService = theUserStatusesService;
    }

    // expose "/statuses" and return a list of userStatus
    @GetMapping("/statuses")
    public List<UserStatuses> findAll(){
        return userStatusesService.findAll();
    }

    // add mapping for Get /statuses/{statusId}
    @GetMapping("/statuses/{statusId}")
    public UserStatuses getUserStatus(@PathVariable int statusId){
        UserStatuses theUserStatuses = userStatusesService.findById(statusId);

        if(theUserStatuses == null){
            throw new RuntimeException("User Relative is not found" + statusId);
        }
        return theUserStatuses;
    }

     //add mapping for POST /statuses - add new userStatus
    @PostMapping("/statuses")
    public UserStatuses addUserStatus(@RequestBody UserStatuses theUserStatuses){
        theUserStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserStatuses.setCreated(localDateTime);
        theUserStatuses.setModified(null);
        UserStatuses newUserRelative = userStatusesService.save(theUserStatuses);
        return newUserRelative;
    }

    // add mapping for PUT /statuses - update existing UserStatus
    @PutMapping("/statuses")
    public UserStatuses updateUserStatus(@RequestBody UserStatuses theUserStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserStatuses.setModified(localDateTime);
        UserStatuses newUserRelative = userStatusesService.save(theUserStatuses);
        return newUserRelative;
    }

    // add mapping for DELETE /statuses/{statusId} - delete userStatus
    @DeleteMapping("/statuses/{statusId}")
    public String deleteUserStatus(@PathVariable int statusId){
        UserStatuses theUserStatuses = userStatusesService.findById(statusId);
        userStatusesService.deleteById(statusId);

        // throw exception if null
        if (theUserStatuses == null){
            throw new RuntimeException("User Status id is not found - " + statusId);
        }
        return "Deleted User Status id - " + statusId;
    }
}
