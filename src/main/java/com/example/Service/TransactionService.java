package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Transaction;
import com.example.Repo.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long transId) {
        return transactionRepository.findById(transId);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long transId, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(transId).orElseThrow();
        transaction.setAccountNumber(transactionDetails.getAccountNumber());
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDescription(transactionDetails.getDescription());
        transaction.setTransactiontype(transactionDetails.getTransactiontype());
        transaction.setTimestamp(transactionDetails.getTimestamp());
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transId) {
        transactionRepository.deleteById(transId);
    }
}
