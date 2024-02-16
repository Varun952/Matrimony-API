package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.BodyTypeDAO;
import com.appxbuild.matrimony.entity.BodyTypes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyTypeServiceImpl implements BodyTypeService{

    private BodyTypeDAO bodyTypeDAO;

    public BodyTypeServiceImpl(BodyTypeDAO bodyTypeDAO) {
        this.bodyTypeDAO = bodyTypeDAO;
    }


    @Override
    public List<BodyTypes> findAll() {
        return bodyTypeDAO.findAll();
    }

    @Override
    public BodyTypes findById(int theId) {

        Optional<BodyTypes> result = bodyTypeDAO.findById(theId);

        BodyTypes bodyTypes = null;

        if(result.isPresent()) {
            bodyTypes = result.get();
        }
        else {
            throw  new RuntimeException("body type id not found "+ theId);
        }


        return bodyTypes;
    }

}
