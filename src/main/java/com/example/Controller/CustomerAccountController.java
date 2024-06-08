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

import com.example.Model.CustomerAccount;
import com.example.Service.CustomerAccountService;

@RestController
@RequestMapping("/api/customeraccounts")
public class CustomerAccountController {

    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping("/readAll")
    public List<CustomerAccount> getAllCustomerAccounts() {
        return customerAccountService.getAllCustomerAccounts();
    }

    @GetMapping("/readOne/{id}")
    public ResponseEntity<CustomerAccount> getCustomerAccountById(@PathVariable Long id) {
        return customerAccountService.getCustomerAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public CustomerAccount createCustomerAccount(@RequestBody CustomerAccount customerAccount) {
        return customerAccountService.createCustomerAccount(customerAccount);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerAccount> updateCustomerAccount(@PathVariable Long id, @RequestBody CustomerAccount customerAccountDetails) {
        return ResponseEntity.ok(customerAccountService.updateCustomerAccount(id, customerAccountDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerAccount(@PathVariable Long id) {
        customerAccountService.deleteCustomerAccount(id);
        return ResponseEntity.noContent().build();
    }
}

