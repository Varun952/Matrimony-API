package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.States;
import com.appxbuild.matrimony.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StateRestController {

    private StatesService statesService;

    @Autowired
    public StateRestController(StatesService theStatesService){
        statesService = theStatesService;
    }

    // expose GET "/states" to get a list of states
    @GetMapping("/states")
    public List<States> findAll(){
       return statesService.findAll();
    }

}
