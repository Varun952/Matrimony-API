package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfileService {

    List<UserProfiles> findAll();
    UserProfiles findById(int theId);
    UserProfiles save(UserProfiles theUserProfiles);
    void deleteById(int theId);
}
