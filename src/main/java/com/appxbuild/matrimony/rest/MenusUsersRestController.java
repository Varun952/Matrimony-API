package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MenusUsers;
import com.appxbuild.matrimony.service.MenusUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenusUsersRestController {

    private MenusUsersService menusUsersService;

    @Autowired
    public MenusUsersRestController(MenusUsersService theMenusUsersService){
        menusUsersService = theMenusUsersService;
    }

    // expose "/menus_users" and return a list of menus
    @GetMapping("/menususers")
    public List<MenusUsers> findAll(){
        return menusUsersService.findAll();
    }

    // add mapping for Get "/menus_users/{menus_userId}"
    @GetMapping("/menususers/{menususersId}")
    public MenusUsers getMenuUser(@PathVariable int menususersId){
        MenusUsers theMenusUser = menusUsersService.findById(menususersId);

        if(theMenusUser == null){
            throw new RuntimeException("Menu User is not found" + menususersId);
        }
        return theMenusUser;
    }

    //add mapping for POST "/menus_users" - add new Menu User
    @PostMapping("/menususers")
    public MenusUsers addMenuUser(@RequestBody MenusUsers theMenusUsers){
        theMenusUsers.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusUsers.setCreated(localDateTime);
        theMenusUsers.setModified(null);
        MenusUsers newMenuUser = menusUsersService.save(theMenusUsers);
        return newMenuUser;
    }

    //add mapping for PUT "/menus_users" - update Menu User
    @PutMapping("/menususers")
    public MenusUsers updateMenuUser(@RequestBody MenusUsers theMenusUsers){
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusUsers.setModified(localDateTime);
        MenusUsers newMenuUser = menusUsersService.save(theMenusUsers);
        return newMenuUser;
    }

    // add mapping for DELETE "/menus_users/{menus_userId}" to delete Menu User
    @DeleteMapping("/menususers/{menususersId}")
    public String deleteMenuUser(@PathVariable int menususersId){
        MenusUsers theMenusUser = menusUsersService.findById(menususersId);
        menusUsersService.deleteById(menususersId);
        if(theMenusUser == null){
            throw new RuntimeException("Menu User is not found" + menususersId);
        }
        return "Deleted Menu User id " + menususersId;
    }

}
