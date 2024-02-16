package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Agencies;

import java.util.List;

public interface AgenciesService {

    List<Agencies> findAll();

    Agencies findById(int theId);

    Agencies save(Agencies theAgencies);

    void deleteById(int theId);

}
