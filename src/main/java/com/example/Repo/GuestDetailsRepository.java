package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.GuestDetails;

@Repository
public interface GuestDetailsRepository extends JpaRepository<GuestDetails, String> {
}
