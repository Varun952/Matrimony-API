package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.FinancialStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinancialStatusesService {

    List<FinancialStatuses> findAll();
    FinancialStatuses findById(int theId);
    FinancialStatuses save(FinancialStatuses theFinancialStatuses);
    void deleteById(int theId);

}
