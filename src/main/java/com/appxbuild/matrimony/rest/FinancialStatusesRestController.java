package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FinancialStatuses;
import com.appxbuild.matrimony.service.FinancialStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinancialStatusesRestController {

    private FinancialStatusesService financialStatusesService;

    @Autowired
    public FinancialStatusesRestController(FinancialStatusesService theFinancialStatusesService){
        financialStatusesService = theFinancialStatusesService;
    }

    // expose GET "/financial_statuses" to get a list of financial statuses
    @GetMapping("/financialstatuses")
    public List<FinancialStatuses> findAll(){
        return financialStatusesService.findAll();
    }


}
