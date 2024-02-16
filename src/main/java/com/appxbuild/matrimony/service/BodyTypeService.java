package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.BodyTypes;

import java.util.List;

public interface BodyTypeService {

    List<BodyTypes> findAll();

    BodyTypes findById(int theId);
}
