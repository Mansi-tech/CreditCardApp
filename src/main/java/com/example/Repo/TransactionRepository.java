package com.example.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	//filter krna hai according to timestamp and type of trans
}
