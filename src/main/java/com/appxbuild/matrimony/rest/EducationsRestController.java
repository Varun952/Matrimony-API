package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Educations;
import com.appxbuild.matrimony.service.EducationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EducationsRestController {

    private EducationsService educationsService;

    @Autowired
    public EducationsRestController(EducationsService theEducationsService){
        educationsService = theEducationsService;
    }

    // expose GET "/educations" to get a list of educations
    @GetMapping("/educations")
    public List<Educations> findAll(){
        return educationsService.findAll();
    }


}
