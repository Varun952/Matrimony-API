package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.Types;
import com.appxbuild.matrimony.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypesRestController {

    private TypesService typesService;

    @Autowired
    public TypesRestController(TypesService theTypesService){
        typesService = theTypesService;
    }

    // expose "/types" and return a list of types
    @GetMapping("/types")
    public List<Types> findAll(){
        return typesService.findAll();
    }

    // add mapping for GET /types/{typeId}
    @GetMapping("/types/{typeId}")
    public Types getTypes(@PathVariable int typeId){
        Types theType = typesService.findById(typeId);
        if(theType == null){
            throw new RuntimeException("type id is not found " + typeId);
        }
        return theType;
    }

    // add mapping for POST /types - add type
    @PostMapping("/types")
    public Types addUserRelative(@RequestBody Types theType){
        theType.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theType.setCreated(localDateTime);
        theType.setModified(null);
        Types newType = typesService.save(theType);
        return newType;
    }

    // add mapping for PUT /relatives - update existing type
    @PutMapping("/types")
    public Types updateType(@RequestBody Types theType){
        LocalDateTime localDateTime = LocalDateTime.now();
        theType.setModified(localDateTime);
        Types newType = typesService.save(theType);
        return newType;
    }

    // add mapping for DELETE /relatives/{relativeId} - delete type
    @DeleteMapping("/types/{typeId}")
    public String deleteType(@PathVariable int typeId){
        Types theType = typesService.findById(typeId);
        typesService.deleteById(typeId);

        // throw exception if null
        if (theType == null){
            throw new RuntimeException("Type id is not found - " + typeId);
        }
        return "Deleted type id - " + typeId;
    }

 }
