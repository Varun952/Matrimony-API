package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Thumbnails;
import com.appxbuild.matrimony.service.ThumbnailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThumbnailRestController {

    private ThumbnailService thumbnailService;

    // constructor
    @Autowired
    public ThumbnailRestController(ThumbnailService thumbnailService) {
        this.thumbnailService = thumbnailService;
    }

    @GetMapping("/thumbnails")
    public List<Thumbnails> findAll() {

        return thumbnailService.findAll();

    }

    @GetMapping("/thumbnails/{thumbnailId}")
    public Thumbnails getUsers(@PathVariable int thumbnailId) {

        Thumbnails thumbnails = thumbnailService.findById(thumbnailId);

        if (thumbnails == null) {
            throw new RuntimeException("thumbnail id not found - " + thumbnailId);
        }

        return thumbnails;
    }

}
