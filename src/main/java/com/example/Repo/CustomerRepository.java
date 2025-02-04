package com.example.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

