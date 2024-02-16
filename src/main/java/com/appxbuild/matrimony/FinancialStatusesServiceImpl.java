package com.appxbuild.matrimony;

import com.appxbuild.matrimony.dao.FinancialStatusesDAO;
import com.appxbuild.matrimony.entity.FinancialStatuses;
import com.appxbuild.matrimony.service.FinancialStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialStatusesServiceImpl implements FinancialStatusesService {

    private FinancialStatusesDAO financialStatusesDAO;

    @Autowired
    public FinancialStatusesServiceImpl(FinancialStatusesDAO theFinancialStatusesDAO){
        financialStatusesDAO = theFinancialStatusesDAO;
    }

    @Override
    public List<FinancialStatuses> findAll() {
        return financialStatusesDAO.findAll();
    }

    @Override
    public FinancialStatuses findById(int theId) {
        Optional<FinancialStatuses> result = financialStatusesDAO.findById(theId);
        FinancialStatuses theFinancialStatus = null;
        if(result.isPresent()){
            theFinancialStatus = result.get();
        }
        else {
            throw new RuntimeException("Financial Status id is not found " + theId);
        }
        return theFinancialStatus;
    }

    @Override
    public FinancialStatuses save(FinancialStatuses theFinancialStatuses) {
        return financialStatusesDAO.save(theFinancialStatuses);
    }

    @Override
    public void deleteById(int theId) {
        financialStatusesDAO.deleteById(theId);
    }
}
