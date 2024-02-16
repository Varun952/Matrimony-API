package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.BloodGroupsDAO;
import com.appxbuild.matrimony.entity.BloodGroups;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodGroupServiceImpl implements BloodGroupService {

    private BloodGroupsDAO bloodGroupsDAO;

    public BloodGroupServiceImpl(BloodGroupsDAO bloodGroupsDAO) {
        this.bloodGroupsDAO = bloodGroupsDAO;
    }

    @Override
    public List<BloodGroups> findAll() {
        return bloodGroupsDAO.findAll();
    }

    @Override
    public BloodGroups findById(int theId) {
        Optional<BloodGroups> result = bloodGroupsDAO.findById(theId);

        BloodGroups bloodGroups = null;

        if(result.isPresent()) {
            bloodGroups = result.get();
        }
        else {
            throw  new RuntimeException("blood Group id not found "+ theId);
        }


        return bloodGroups;
    }
}
