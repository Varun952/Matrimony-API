package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MenusTypes;
import com.appxbuild.matrimony.service.MenusTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenusTypesRestController {

    private MenusTypesService menusTypesService;

    @Autowired
    public MenusTypesRestController(MenusTypesService theMenusTypesService){
        menusTypesService = theMenusTypesService;
    }

    // expose "/menus_types" and return a list of Menus Types
    @GetMapping("/menustypes")
    public List<MenusTypes> findAll(){
        return menusTypesService.findAll();
    }

    // add mapping for Get "/menus_types/{menus_typeId}"
    @GetMapping("/menustypes/{menustypesId}")
    public MenusTypes getMenuType(@PathVariable int menustypesId){
        MenusTypes theMenuType = menusTypesService.findById(menustypesId);

        if(theMenuType == null){
            throw new RuntimeException("Menu Type is not found" + menustypesId);
        }
        return theMenuType;
    }

    //add mapping for POST "/menus_types" - add new Menu Type
    @PostMapping("/menustypes")
    public MenusTypes addMenuType(@RequestBody MenusTypes theMenusTypes){
        theMenusTypes.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusTypes.setCreated(localDateTime);
        theMenusTypes.setModified(null);
        MenusTypes newMenuTypes = menusTypesService.save(theMenusTypes);
        return newMenuTypes;
    }

    //add mapping for PUT "/menus_types" - update Menu Type
    @PutMapping("/menustypes")
    public MenusTypes updateMenuType(@RequestBody MenusTypes theMenusTypes){
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusTypes.setModified(localDateTime);
        MenusTypes newMenuTypes = menusTypesService.save(theMenusTypes);
        return newMenuTypes;
    }

    // add mapping for DELETE "/menus_types/{menus_typeId}" to delete menu type
    @DeleteMapping("/menustypes/{menustypesId}")
    public String deleteMenuType(@PathVariable int menustypesId){
        MenusTypes theMenuType = menusTypesService.findById(menustypesId);
        menusTypesService.deleteById(menustypesId);
        if(theMenuType == null){
            throw new RuntimeException("Menu Type is not found" + menustypesId);
        }
        return "Deleted Menu Type id " + menustypesId;
    }

}
