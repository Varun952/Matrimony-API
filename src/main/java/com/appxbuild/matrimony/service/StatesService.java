package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.States;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatesService {

    List<States> findAll();
    States findById(int theId);
    States save(States thStates);
    void deleteById(int theId);
}
