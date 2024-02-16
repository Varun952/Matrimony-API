package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.AgenciesDAO;
import com.appxbuild.matrimony.entity.Agencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciesServiceImpl implements AgenciesService{

    private AgenciesDAO agenciesDAO;

    @Autowired
    public AgenciesServiceImpl(AgenciesDAO agenciesDAO) {
        this.agenciesDAO = agenciesDAO;
    }

    @Override
    public List<Agencies> findAll() {
        return agenciesDAO.findAll();
    }

    @Override
    public Agencies findById(int theId) {
        Optional<Agencies> result = agenciesDAO.findById(theId);

        Agencies theAgencies = null;
        if (result.isPresent()){
            theAgencies = result.get();
        }
        else {
            throw new RuntimeException("Did not find agency id - " + theId);
        }
        return theAgencies;
    }

    @Override
    public Agencies save(Agencies theAgencies) {
        return agenciesDAO.save(theAgencies);
    }


    @Override
    public void deleteById(int theId) {
        agenciesDAO.deleteById(theId);
    }
}
