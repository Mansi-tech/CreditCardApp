package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.CustomerCardDetails;
import com.example.Repo.CustomerCardDetailsRepository;

@Service
public class CustomerCardDetailsService {

    @Autowired
    private CustomerCardDetailsRepository customerCardDetailsRepository;

    public List<CustomerCardDetails> getAllCustomerCardDetails() {
        return customerCardDetailsRepository.findAll();
    }

    public Optional<CustomerCardDetails> getCustomerCardDetailsById(Long cardNumber) {
        return customerCardDetailsRepository.findById(cardNumber);
    }

    public CustomerCardDetails createCustomerCardDetails(CustomerCardDetails customerCardDetails) {
        return customerCardDetailsRepository.save(customerCardDetails);
    }

    public CustomerCardDetails updateCustomerCardDetails( CustomerCardDetails customerCardDetailsDetails) {
        CustomerCardDetails customerCardDetails = customerCardDetailsRepository.findById(customerCardDetailsDetails.getCardNumber()).orElseThrow();
        customerCardDetails.setCustomerAccount(customerCardDetailsDetails.getCustomerAccount());
        customerCardDetails.setCustomer(customerCardDetailsDetails.getCustomer());
        customerCardDetails.setCardStatus(customerCardDetailsDetails.getCardStatus());
        customerCardDetails.setInternationalPayment(customerCardDetailsDetails.getInternationalPayment());
        customerCardDetails.setOnlinePayment(customerCardDetailsDetails.getOnlinePayment());
        customerCardDetails.setCardBalance(customerCardDetailsDetails.getCardBalance());
        customerCardDetails.setDueAmount(customerCardDetailsDetails.getDueAmount());
        customerCardDetails.setDueDate(customerCardDetailsDetails.getDueDate());
        customerCardDetails.setCardType(customerCardDetailsDetails.getCardType());
        return customerCardDetailsRepository.save(customerCardDetails);
    }

    public void deleteCustomerCardDetails(Long cardNumber) {
        customerCardDetailsRepository.deleteById(cardNumber);
    }
}

