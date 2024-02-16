package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStatusesService {

    List<UserStatuses> findAll();
    UserStatuses findById(int theId);
    UserStatuses save(UserStatuses theUserStatuses);
    void deleteById(int theId);

}
