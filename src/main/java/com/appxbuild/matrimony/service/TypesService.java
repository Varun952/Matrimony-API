package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Types;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypesService {

    List<Types> findAll();
    Types findById(int theId);
    Types save(Types theTypes);
    void deleteById(int theId);

}
