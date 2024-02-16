package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users,Integer> {

    // no need to write anything
}
