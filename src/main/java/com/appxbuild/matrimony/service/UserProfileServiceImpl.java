package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserProfileDAO;
import com.appxbuild.matrimony.entity.UserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    private UserProfileDAO userProfileDAO;

    @Autowired
    public UserProfileServiceImpl(UserProfileDAO theUserProfileDAO){
        userProfileDAO = theUserProfileDAO;
    }

    @Override
    public List<UserProfiles> findAll() {
        return userProfileDAO.findAll();
    }

    @Override
    public UserProfiles findById(int theId) {
        Optional<UserProfiles> result = userProfileDAO.findById(theId);
        UserProfiles theUserProfiles = null;
        if(result.isPresent()){
            theUserProfiles = result.get();
        }
        else {
            throw new RuntimeException("User Profile id is not found " + theId);
        }
        return theUserProfiles;
    }

    @Override
    public UserProfiles save(UserProfiles theUserProfiles) {
        return userProfileDAO.save(theUserProfiles);
    }

    @Override
    public void deleteById(int theId) {

        userProfileDAO.deleteById(theId);
    }
}
