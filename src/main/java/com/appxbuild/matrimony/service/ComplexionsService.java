package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Complexions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplexionsService {

    List<Complexions> findAll();
    Complexions findById(int theId);
    Complexions save(Complexions theComplexions);
    void deleteById(int theId);
}
