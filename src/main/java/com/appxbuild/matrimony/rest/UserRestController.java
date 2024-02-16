package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Users;
import com.appxbuild.matrimony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{usersId}")
    public Users getUsers(@PathVariable int usersId) {

        Users theUserStatuses = userService.findById(usersId);

        if (theUserStatuses == null) {
            throw new RuntimeException("Users id not found - " + usersId);
        }

        return theUserStatuses;
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users users){

        users.setId(0);

        LocalDateTime localDateTime = LocalDateTime.now();
        users.setCreated(localDateTime);
        users.setModified(null);

        Users  dbUser = userService.save(users);

        return dbUser;
    }

    // updating existing users
    @PutMapping("/users")
    public Users updateUserStatuses(@RequestBody Users users) {

        LocalDateTime localDateTime = LocalDateTime.now();
        users.setModified(localDateTime);

        Users dbUserStatus = userService.save(users);

        return dbUserStatus;
    }

    @DeleteMapping("/users/{usersId}")
    public String deleteUser(@PathVariable int usersId) {

        Users users = userService.findById(usersId);

        // thorw exception if null
        if(users == null)
        {
            throw new RuntimeException("User is not found-"+ usersId );
        }

        userService.deleteById(usersId);

        return "Deleted user id -" + usersId;
    }
}
