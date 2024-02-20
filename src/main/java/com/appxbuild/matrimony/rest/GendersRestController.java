package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Genders;
import com.appxbuild.matrimony.service.GendersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GendersRestController {

    private GendersService gendersService;

    @Autowired
    public GendersRestController(GendersService theGendersService)  {
        gendersService = theGendersService;
    }

    // expose GET "/genders" to get a list of Genders
    @GetMapping("/genders")
    public List<Genders> findAll(){
        return gendersService.findAll();
    }

}
