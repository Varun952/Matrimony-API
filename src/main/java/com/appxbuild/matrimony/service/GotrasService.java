package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Gotras;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GotrasService {

    List<Gotras> findAll();
    Gotras findById(int theId);
    Gotras save(Gotras theGotras);
    void deleteById(int theId);

}
