package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UsersStatusesDAO;
import com.appxbuild.matrimony.entity.UserStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStatusesServiceImpl implements UserStatusesService {

    private UsersStatusesDAO usersStatusesDAO;

    @Autowired
    public UserStatusesServiceImpl(UsersStatusesDAO theUsersStatusesDAO){
        usersStatusesDAO = theUsersStatusesDAO;
    }


    @Override
    public List<UserStatuses> findAll() {
        return usersStatusesDAO.findAll();
    }

    @Override
    public UserStatuses findById(int theId) {
        Optional<UserStatuses> result = usersStatusesDAO.findById(theId);

        UserStatuses theUserStatuses = null;
        if (result.isPresent()){
            theUserStatuses = result.get();
        }
        else {
            throw new RuntimeException("Did not find user status id - " + theId);
        }
        return theUserStatuses;
    }

    @Override
    public UserStatuses save(UserStatuses theUserStatuses) {
        return usersStatusesDAO.save(theUserStatuses);
    }


    @Override
    public void deleteById(int theId) {
        usersStatusesDAO.deleteById(theId);
    }
}
