package com.example.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}

