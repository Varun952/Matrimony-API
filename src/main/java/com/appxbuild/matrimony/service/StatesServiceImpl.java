package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.StatesDAO;
import com.appxbuild.matrimony.entity.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesServiceImpl implements StatesService{

    private StatesDAO statesDAO;

    @Autowired
    public StatesServiceImpl(StatesDAO theStatesDAO){
        statesDAO = theStatesDAO;
    }

    @Override
    public List<States> findAll() {
        return statesDAO.findAll();
    }

    @Override
    public States findById(int theId) {
        Optional<States> result = statesDAO.findById(theId);
        States theState = null;
        if (result.isPresent()){
            theState = result.get();
        }
        else {
            throw new RuntimeException("State id is not found " + theId);
        }
        return theState;
    }

    @Override
    public States save(States thStates) {
        return statesDAO.save(thStates);
    }

    @Override
    public void deleteById(int theId) {
        statesDAO.deleteById(theId);
    }
}
