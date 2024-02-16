package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.UserStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersStatusesDAO extends JpaRepository<UserStatuses, Integer> {
}
