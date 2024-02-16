package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.BodyTypes;
import com.appxbuild.matrimony.service.BodyTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BodyTypeRestController {

    private BodyTypeService bodyTypeService;


    public BodyTypeRestController(BodyTypeService bodyTypeService) {
        this.bodyTypeService = bodyTypeService;
    }



    @GetMapping("/bodytypes")
    public List<BodyTypes> findAll() {
        return bodyTypeService.findAll();
    }

    @GetMapping("/bodytypes/{bodytypeId}")
    public BodyTypes findById(@PathVariable int bodytypeId ) {

        BodyTypes bodyTypes = bodyTypeService.findById(bodytypeId);

        if (bodyTypes == null) {
            throw new RuntimeException("body Type  id not found - " + bodytypeId);
        }

        return bodyTypes;
    }
}
