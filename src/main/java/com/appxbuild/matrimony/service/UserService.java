package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int theId);

    Users save(Users users);

    void deleteById(int theId);

}
