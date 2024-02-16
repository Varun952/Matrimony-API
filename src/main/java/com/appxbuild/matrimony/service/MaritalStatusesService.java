package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.MaritalStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaritalStatusesService {

    List<MaritalStatuses> findAll();
    MaritalStatuses findById(int theId);
    MaritalStatuses save(MaritalStatuses theMaritalStatuses);
    void deleteById(int theId);

}
