package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Drinks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinksService {

    List<Drinks> findAll();
    Drinks findById(int theId);
    Drinks save(Drinks theDrinks);
    void deleteById(int theId);

}
