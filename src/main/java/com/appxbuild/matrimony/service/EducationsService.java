package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Educations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationsService {

    List<Educations> findAll();
    Educations findById(int theId);
    Educations save(Educations theEducations);
    void deleteById(int theId);

}
