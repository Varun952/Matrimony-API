package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.PaymentGateways;
import com.appxbuild.matrimony.service.PaymentGatewaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentGatewaysRestController {

    private PaymentGatewaysService paymentGatewaysService;

    @Autowired
    public PaymentGatewaysRestController(PaymentGatewaysService thePaymentGatewaysService){
        paymentGatewaysService = thePaymentGatewaysService;
    }

    // expose GET "/payment_gateways" to get a list of paymentGateways
    @GetMapping("/paymentgateways")
    public List<PaymentGateways> findAll(){
        return paymentGatewaysService.findAll();
    }

    // add mapping for GET "/payment_gateways/{payment_gatewaysId}" to get paymentGateway
    @GetMapping("/paymentgateways/{paymentgatewaysId}")
    public PaymentGateways getById(@PathVariable int paymentgatewaysId){
        PaymentGateways thePaymentGateways = paymentGatewaysService.findById(paymentgatewaysId);
        if(thePaymentGateways == null){
            throw new RuntimeException("Payment Gateway id is  not found " + paymentgatewaysId);
        }
        return thePaymentGateways;
    }

    // add mapping for POST "/payment_gateways" to add new paymentGateway
    @PostMapping("/paymentgateways")
    public PaymentGateways addPaymentGateway(@RequestBody PaymentGateways thePaymentGateways){
        thePaymentGateways.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePaymentGateways.setCreated(localDateTime);
        thePaymentGateways.setModified(null);
        PaymentGateways newPaymentGateways = paymentGatewaysService.save(thePaymentGateways);
        return newPaymentGateways;
    }

    // add mapping for PUT "/payment_gateways" to update paymentGateway
    @PutMapping("/paymentgateways")
    public PaymentGateways updatePaymentGateway(@RequestBody PaymentGateways thePaymentGateways){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePaymentGateways.setModified(localDateTime);
        PaymentGateways newPaymentGateways = paymentGatewaysService.save(thePaymentGateways);
        return newPaymentGateways;
    }

    // add mapping for GET "/payment_gateways/{payment_gatewaysId}" to get paymentGateway
    @DeleteMapping("/paymentgateways/{paymentgatewaysId}")
    public String deleteById(@PathVariable int paymentgatewaysId){
        PaymentGateways thePaymentGateways = paymentGatewaysService.findById(paymentgatewaysId);
        paymentGatewaysService.deleteById(paymentgatewaysId);
        if(thePaymentGateways == null){
            throw new RuntimeException("Payment Gateway id is  not found " + paymentgatewaysId);
        }
        return "deleted Payment Gateway id " + paymentgatewaysId;
    }
}
