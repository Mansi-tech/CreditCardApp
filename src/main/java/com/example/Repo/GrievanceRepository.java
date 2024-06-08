package com.example.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Grievance;

@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {
}

