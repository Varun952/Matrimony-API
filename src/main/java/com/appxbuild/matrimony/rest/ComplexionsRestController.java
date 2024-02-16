package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Complexions;
import com.appxbuild.matrimony.service.ComplexionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComplexionsRestController {

    private ComplexionsService complexionsService;

    @Autowired
    public ComplexionsRestController(ComplexionsService theComplexionsService){
        complexionsService = theComplexionsService;
    }

    // expose GET "/complexions" to get a list of complexions
    @GetMapping("/complexions")
    public List<Complexions> findALl(){
        return complexionsService.findAll();
    }
}
