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

import com.example.Model.Grievance;
import com.example.Service.GrievanceService;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceService grievanceService;

    @GetMapping("/readAll")
    public List<Grievance> getAllGrievances() {
        return grievanceService.getAllGrievances();
    }

    @GetMapping("/readOne/{grievanceId}")
    public ResponseEntity<Grievance> getGrievanceById(@PathVariable Long grievanceId) {
        return grievanceService.getGrievanceById(grievanceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Grievance createGrievance(@RequestBody Grievance grievance) {
        return grievanceService.createGrievance(grievance);
    }

    @PutMapping("/update")
    public ResponseEntity<Grievance> updateGrievance( @RequestBody Grievance grievanceDetails) {
        return ResponseEntity.ok(grievanceService.updateGrievance(grievanceDetails));
    }

    @DeleteMapping("/delete/{grievanceId}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long grievanceId) {
        grievanceService.deleteGrievance(grievanceId);
        return ResponseEntity.noContent().build();
    }
}

