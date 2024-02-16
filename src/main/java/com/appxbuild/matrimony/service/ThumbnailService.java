package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Thumbnails;

import java.util.List;

public interface ThumbnailService {

    List<Thumbnails> findAll();

    Thumbnails findById(int theId);

//    Thumbnails save(Thumbnails thumbnails);
//
//    void deleteById(int theId);

}
