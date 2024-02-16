package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Genders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GendersService {

    List<Genders> findAll();
    Genders findById(int theId);
    Genders save(Genders theGenders);
    void deleteById(int theId);

}
