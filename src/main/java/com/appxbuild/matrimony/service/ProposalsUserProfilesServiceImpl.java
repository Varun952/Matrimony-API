package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ProposalsUserProfilesDAO;
import com.appxbuild.matrimony.entity.ProposalsUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalsUserProfilesServiceImpl implements ProposalsUserProfilesService{

    private ProposalsUserProfilesDAO proposalsUserProfilesDAO;

    @Autowired
    public ProposalsUserProfilesServiceImpl(ProposalsUserProfilesDAO proposalsUserProfilesDAO) {
        this.proposalsUserProfilesDAO = proposalsUserProfilesDAO;
    }


    @Override
    public List<ProposalsUserProfiles> findAll() {
        return proposalsUserProfilesDAO.findAll();
    }
}
