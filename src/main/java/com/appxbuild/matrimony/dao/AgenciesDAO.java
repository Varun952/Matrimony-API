package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Agencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciesDAO extends JpaRepository<Agencies, Integer> {
    // no need to write any thing
}
