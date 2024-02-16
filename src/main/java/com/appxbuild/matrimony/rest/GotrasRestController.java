package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Gotras;
import com.appxbuild.matrimony.service.GotrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GotrasRestController {

    private GotrasService gotrasService;

    @Autowired
    public GotrasRestController(GotrasService theGotrasService){
        gotrasService = theGotrasService;
    }

    // expose GET "/gotras" to get a list of gotras
    @GetMapping("/gotras")
    public List<Gotras> findAll(){
        return gotrasService.findAll();
    }


}
