package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.CustomerAccount;
import com.example.Repo.CustomerAccountRepository;

@Service
public class CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    public List<CustomerAccount> getAllCustomerAccounts() {
        return customerAccountRepository.findAll();
    }

    public Optional<CustomerAccount> getCustomerAccountById(Long id) {
        return customerAccountRepository.findById(id);
    }

    public CustomerAccount createCustomerAccount(CustomerAccount customerAccount) {
        return customerAccountRepository.save(customerAccount);
    }

    public CustomerAccount updateCustomerAccount(Long id, CustomerAccount customerAccountDetails) {
        CustomerAccount customerAccount = customerAccountRepository.findById(id).orElseThrow();
        customerAccount.setCustomer(customerAccountDetails.getCustomer());
        customerAccount.setBaseCurrency(customerAccountDetails.getBaseCurrency());
        customerAccount.setOpeningDate(customerAccountDetails.getOpeningDate());
        customerAccount.setStatus(customerAccountDetails.getStatus());
        return customerAccountRepository.save(customerAccount);
    }

    public void deleteCustomerAccount(Long id) {
        customerAccountRepository.deleteById(id);
    }
}

