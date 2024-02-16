package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.OccupationsDAO;
import com.appxbuild.matrimony.entity.Occupations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationsServiceImpl implements OccupationsService{

    private OccupationsDAO occupationsDAO;

    @Autowired
    public OccupationsServiceImpl(OccupationsDAO theOccupationsDAO){
        occupationsDAO = theOccupationsDAO;
    }

    @Override
    public List<Occupations> findAll() {
        return occupationsDAO.findAll();
    }

    @Override
    public Occupations findById(int theId) {
        Optional<Occupations> result = occupationsDAO.findById(theId);
        Occupations theOccupation = null;
        if(result.isPresent()){
            theOccupation = result.get();
        }
        else {
            throw  new RuntimeException("Occupation id is not found " + theId);
        }
        return theOccupation;
    }

    @Override
    public Occupations save(Occupations theOccupations) {
        return occupationsDAO.save(theOccupations);
    }

    @Override
    public void deleteById(int theId) {
        occupationsDAO.deleteById(theId);
    }
}
