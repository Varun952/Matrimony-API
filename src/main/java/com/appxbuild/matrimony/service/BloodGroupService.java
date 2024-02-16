package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.BloodGroups;

import java.util.List;

public interface BloodGroupService {

    List<BloodGroups> findAll();

    BloodGroups findById(int theiId);
}
