package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.TransactionsStatuses;
import com.appxbuild.matrimony.service.TransactionsStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsStatusesRestController {

    private TransactionsStatusesService transactionsStatusesService;

    @Autowired()
    public TransactionsStatusesRestController(TransactionsStatusesService theTransactionsStatusesService){
        transactionsStatusesService = theTransactionsStatusesService;
    }


    // expose "/transactions_statuses" and return a list of transactionsStatuses
    @GetMapping("/transactionsstatuses")
    public List<TransactionsStatuses> findAll(){
        return transactionsStatusesService.findAll();
    }

    // add mapping for GET "/transactions_statuses/{transactions_statusesId}"
    @GetMapping("/transactionsstatuses/{transactionsstatusesId}")
    public TransactionsStatuses getTransactionStatus(@PathVariable int transactionsstatusesId){
        TransactionsStatuses theTransactionsStatus = transactionsStatusesService.findById(transactionsstatusesId);
        if(theTransactionsStatus == null){
            throw new RuntimeException("Transaction Status id is not found " + transactionsstatusesId);
        }
        return theTransactionsStatus;
    }

    // add mapping for POST "/transactions_statuses to add new transactionStatuses
    @PostMapping("/transactionsstatuses")
    public TransactionsStatuses addTransactionStatus(@RequestBody TransactionsStatuses theTransactionsStatuses){
        theTransactionsStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactionsStatuses.setCreated(localDateTime);
        theTransactionsStatuses.setModified(null);
        TransactionsStatuses newTransactionsStatuses = transactionsStatusesService.save(theTransactionsStatuses);
        return newTransactionsStatuses;
    }

    // add mapping for PUT "/transactions_statuses to update transactionStatus
    @PutMapping("/transactionsstatuses")
    public TransactionsStatuses updateTransactionStatus(@RequestBody TransactionsStatuses theTransactionsStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactionsStatuses.setModified(localDateTime);
        TransactionsStatuses newTransactionsStatuses = transactionsStatusesService.save(theTransactionsStatuses);
        return newTransactionsStatuses;
    }

    // add mapping for DELETE "/transactions_statuses to delete transactionStatus
    @DeleteMapping("/transactionsstatuses/{transactionsstatuses}")
    public String deleteTransactionStatus(@PathVariable int transactionsstatusesId){
        TransactionsStatuses theTransactionsStatuses = transactionsStatusesService.findById(transactionsstatusesId);
        transactionsStatusesService.deleteById(transactionsstatusesId);
        if(theTransactionsStatuses == null){
            throw new RuntimeException("Transaction Status id not found " + transactionsstatusesId);
        }
        return "deleted Transaction Status id " + transactionsstatusesId;
    }

}
