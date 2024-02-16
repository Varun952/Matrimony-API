package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.Smokes;
import com.appxbuild.matrimony.service.SmokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SmokesRestController {

    private SmokesService smokesService;

    @Autowired
    public SmokesRestController(SmokesService theSmokesService){
        smokesService = theSmokesService;
    }

    // expose "/smokes" and return a list of userRelatives
    @GetMapping("/smokes")
    public List<Smokes> findAll(){
        return smokesService.findAll();
    }

}
