package com.example.Model;



//import javax.persistence.*;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grievance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grievance {
    
    @Id
    @Column(name = "grievanceid")
    private Long grievanceId;

    @ManyToOne
    @JoinColumn(name = "accountnumber", referencedColumnName = "accountno")
    private CustomerAccount accountNumber;

    @Column(name = "subject", length = 500, nullable = false)
    private String subject;

    @Column(name = "description", length = 3000, nullable = false)
    private String description;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
}

