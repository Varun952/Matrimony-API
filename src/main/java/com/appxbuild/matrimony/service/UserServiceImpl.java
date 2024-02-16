package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserDAO;
import com.appxbuild.matrimony.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<Users> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = userDAO.findById(theId);

        Users user = null;

        if(result.isPresent())
        {
            user = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find user id -" + theId);
        }

        return user;
    }

    @Override
    public Users save(Users users) {
        return userDAO.save(users);
    }

    @Override
    public void deleteById(int theId) {

        userDAO.deleteById(theId);
    }
}
