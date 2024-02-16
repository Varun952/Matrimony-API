package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AppUpdates;
import com.appxbuild.matrimony.service.AppUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppUpdatesRestController {

    private AppUpdateService appUpdateService;

    @Autowired
    public AppUpdatesRestController(AppUpdateService theAppUpdateService){
        appUpdateService = theAppUpdateService;
    }

    // expose GET "/app_updates" to get a list of app updates
    @GetMapping("/appupdates")
    public List<AppUpdates> findALl(){
       return appUpdateService.findALl();
    }

    // add mapping for GET "/app_updates/{app_updateId}" to get a app update
    @GetMapping("/appupdates/{appupdatesId}")
    public AppUpdates findById(@PathVariable int appupdatesId){
        AppUpdates theAppUpdate = appUpdateService.findByAll(appupdatesId);
        if(theAppUpdate == null){
            throw new RuntimeException("App Update id is not found " + appupdatesId);
        }
        return theAppUpdate;
    }

    // add mapping for POST "/appupdates" to add a new app update
    @PostMapping("/app_updates")
    public AppUpdates addAppUpdate(@RequestBody AppUpdates theAppUpdates){
        theAppUpdates.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theAppUpdates.setCreated(localDateTime);
        theAppUpdates.setModified(null);
        AppUpdates newAppUpdate = appUpdateService.save(theAppUpdates);
        return newAppUpdate;
    }

    // add mapping for PUT "/appupdates" to update an app update
    @PutMapping("/appupdates")
    public AppUpdates updateAppUpdate(@RequestBody AppUpdates theAppUpdates){
        LocalDateTime localDateTime = LocalDateTime.now();
        theAppUpdates.setModified(localDateTime);
        AppUpdates newAppUpdate = appUpdateService.save(theAppUpdates);
        return newAppUpdate;
    }

    // add mapping for DELETE "/app_updates/{app_updateId}" to delete an app update
    @DeleteMapping("/appupdates/{appupdatesId}")
    public String deleteById(@PathVariable int appupdatesId){
        AppUpdates theAppUpdate = appUpdateService.findByAll(appupdatesId);
        appUpdateService.deleteById(appupdatesId);
        if(theAppUpdate == null){
            throw new RuntimeException("App Update id is not found " + appupdatesId);
        }
        return "Deleted App Update Id " + appupdatesId;
    }

}
