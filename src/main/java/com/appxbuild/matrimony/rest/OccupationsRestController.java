package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Occupations;
import com.appxbuild.matrimony.service.OccupationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class OccupationsRestController {

    private OccupationsService occupationsService;

    @Autowired
    public OccupationsRestController(OccupationsService theOccupationsService){
        occupationsService = theOccupationsService;
    }

    // expose "/occupations" and return a list of Occupations
    @GetMapping("/occupations")
    public List<Occupations> findAll() {
        return occupationsService.findAll();
    }

    // add mapping for Get "/occupations/{friendId}"
    @GetMapping("/occupations/{occupationId}")
    public Occupations getOccupation(@PathVariable int occupationId){
        Occupations theOccupation = occupationsService.findById(occupationId);

        if(theOccupation == null){
            throw new RuntimeException("Occupation id is not found" + occupationId);
        }
        return theOccupation;
    }

    // add mapping for POST "/occupations" - add new Occupation
    @PostMapping("/occupations")
    public Occupations addOccupation(@RequestBody Occupations theOccupations){
        theOccupations.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theOccupations.setCreated(localDateTime);
        theOccupations.setModified(null);
        Occupations newOccupation = occupationsService.save(theOccupations);
        return newOccupation;
    }

    // add mapping for PUT "/occupations" - update existing Occupation
    @PutMapping("/occupations")
    public Occupations updateOccupation(@RequestBody Occupations theOccupations){
        LocalDateTime localDateTime = LocalDateTime.now();
        theOccupations.setModified(localDateTime);
        Occupations newOccupation = occupationsService.save(theOccupations);
        return newOccupation;
    }

    // add mapping for DELETE "/occupations/{occupationId}" - delete Occupation
    @DeleteMapping("/occupations/{occupationId}")
    public String deleteOccupation(@PathVariable int occupationId){
        Occupations theOccupation = occupationsService.findById(occupationId);
        occupationsService.deleteById(occupationId);

        // throw exception if null
        if (theOccupation == null){
            throw new RuntimeException("Occupation id is not found - " + occupationId);
        }
        return "Deleted Occupation id - " + occupationId;
    }

}

