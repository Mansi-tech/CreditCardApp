package com.example.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.CustomerCardDetails;
import com.example.Service.CustomerCardDetailsService;

@RestController
@RequestMapping("/api/customercarddetails")
public class CustomerCardDetailsController {

    @Autowired
    private CustomerCardDetailsService customerCardDetailsService;

    @GetMapping("/readAll")
    public List<CustomerCardDetails> getAllCustomerCardDetails() {
        return customerCardDetailsService.getAllCustomerCardDetails();
    }
    
    // card number nhi dete ese ..path var mein, request body mein do
    @GetMapping("/readOne")
    public ResponseEntity<CustomerCardDetails> getCustomerCardDetailsById( @RequestBody CustomerCardDetails customerCardDetails) {
        return customerCardDetailsService.getCustomerCardDetailsById(customerCardDetails.getCardNumber())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public CustomerCardDetails createCustomerCardDetails(@RequestBody CustomerCardDetails customerCardDetails) {
        return customerCardDetailsService.createCustomerCardDetails(customerCardDetails);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerCardDetails> updateCustomerCardDetails( @RequestBody CustomerCardDetails customerCardDetails) {
        return ResponseEntity.ok(customerCardDetailsService.updateCustomerCardDetails(customerCardDetails));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCustomerCardDetails( @RequestBody CustomerCardDetails customerCardDetails) {
        customerCardDetailsService.deleteCustomerCardDetails(customerCardDetails.getCardNumber());
        return ResponseEntity.noContent().build();
    }
    
    
    
    
}


