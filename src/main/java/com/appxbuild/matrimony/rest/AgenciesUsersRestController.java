package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AgenciesUsers;
import com.appxbuild.matrimony.service.AgenciesUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgenciesUsersRestController {

    private AgenciesUsersService agenciesUsersService;

    @Autowired
    public AgenciesUsersRestController(AgenciesUsersService theAgenciesUsersService){
        agenciesUsersService = theAgenciesUsersService;
    }

    // expose GET "/agencies_users" to get a list of agencyUsers
    @GetMapping("/agenciesusers")
    public List<AgenciesUsers> findAll() {
        return agenciesUsersService.findAll();
    }

    // add mapping for GET "/agenciesusers/{agenciesusersId}" to get an agency user
    @GetMapping("/agenciesusers/{agenciesusersId}")
    public AgenciesUsers findById(@PathVariable int agenciesusersId){
        AgenciesUsers theAgenciesUsers = agenciesUsersService.findById(agenciesusersId);
        if(theAgenciesUsers == null){
            throw  new RuntimeException("Agency User id is not found " + agenciesusersId);
        }
        return theAgenciesUsers;
    }

    // add mapping for POST "/agenciesusers" to add a new agency user
    @PostMapping("/agenciesusers")
    private AgenciesUsers addAgencyUser(@RequestBody AgenciesUsers theAgenciesUsers){
         theAgenciesUsers.setId(0);
         long millis = System.currentTimeMillis();
         Timestamp timestamp = new Timestamp(millis);
         theAgenciesUsers.setCreated(timestamp);
         theAgenciesUsers.setModified(null);
         AgenciesUsers newAgenciesUser = agenciesUsersService.save(theAgenciesUsers);
         return newAgenciesUser;
    }

    // add mapping for PUT "/agenciesusers"" to update agency user
    @PutMapping("/agenciesusers")
    private AgenciesUsers updateAgencyUser(@RequestBody AgenciesUsers theAgenciesUsers){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theAgenciesUsers.setModified(timestamp);
        AgenciesUsers newaAgenciesUsers = agenciesUsersService.save(theAgenciesUsers);
        return newaAgenciesUsers;
    }

    // add mapping for DELETE "/agenciesusers/{agenciesusersId}" to delete agency user
    @DeleteMapping("/agenciesusers/{agenciesusersId}")
    private String deleteById(@PathVariable int agenciesusersId){
        AgenciesUsers theAgenciesUsers = agenciesUsersService.findById(agenciesusersId);
        agenciesUsersService.deleteById(agenciesusersId);
        if (theAgenciesUsers == null){
            throw new RuntimeException("Agency User id id not found " + agenciesusersId);
        }
        return "Deleted Agency User Id " + agenciesusersId;
    }


}
