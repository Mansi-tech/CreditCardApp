package com.example.Model;

//import javax.persistence.*;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "customeraccount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount {
    
    @Id
    @Column(name = "accountno")
    private Long accountNo;

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customer customer;

    @Column(name = "basecurrency")
    private String baseCurrency;

    @Column(name = "openingdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date openingDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}

