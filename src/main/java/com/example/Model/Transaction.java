package com.example.Model;



//import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.example.Model.CustomerCardDetails.PaymentStatus;

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
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    
    @Id
    @Column(name = "transid")
    private Long transId;

    @ManyToOne
    @JoinColumn(name = "accountnumber", referencedColumnName = "accountno")
    private CustomerAccount accountNumber;

    @Column(name = "amount", precision = 10, scale = 4)
    private BigDecimal amount;

    @Column(name = "description", length = 100)
    private String description;
    
    @Column(name = "transactionType")
    @Enumerated(EnumType.STRING)
    private  TransactionType transactiontype;

    public enum TransactionType {
        DEBIT, CREDIT
    }

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
}

