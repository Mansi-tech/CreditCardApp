package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Grievance;
import com.example.Repo.GrievanceRepository;

@Service
public class GrievanceService {

    @Autowired
    private GrievanceRepository grievanceRepository;

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Optional<Grievance> getGrievanceById(Long grievanceId) {
        return grievanceRepository.findById(grievanceId);
    }

    public Grievance createGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    public Grievance updateGrievance( Grievance grievanceDetails) {
        Grievance grievance = grievanceRepository.findById(grievanceDetails.getGrievanceId()).orElseThrow();
        grievance.setAccountNumber(grievanceDetails.getAccountNumber());
        grievance.setSubject(grievanceDetails.getSubject());
        grievance.setDescription(grievanceDetails.getDescription());
        grievance.setTimestamp(grievanceDetails.getTimestamp());
        return grievanceRepository.save(grievance);
    }

    public void deleteGrievance(Long grievanceId) {
        grievanceRepository.deleteById(grievanceId);
    }
}
