package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Drinks;
import com.appxbuild.matrimony.service.DrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrinksRestController {

    private DrinksService drinksService;

    @Autowired
    public DrinksRestController(DrinksService theDrinksService){
        drinksService = theDrinksService;
    }

    // expose GET "/drinks" to get a list of drinks
    @GetMapping("/drinks")
    public List<Drinks> findAll(){
        return drinksService.findAll();
    }
}
