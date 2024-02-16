package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.BodyTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyTypeDAO extends JpaRepository<BodyTypes, Integer> {

    // no need to write

}
