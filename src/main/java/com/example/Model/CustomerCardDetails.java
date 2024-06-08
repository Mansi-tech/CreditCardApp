package com.example.Model;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customercarddetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardDetails {
    
    @Id
    @Column(name = "cardnumber")
    private Long cardNumber;

//    @ManyToOne
//    @JoinColumn(name = "accountno", referencedColumnName = "accountno")
//    private CustomerAccount customerAccount;
    
    @OneToOne
    @JoinColumn(name = "accountno", referencedColumnName = "accountno")
    private CustomerAccount customerAccount;

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customer customer;

    @Column(name = "cardstatus")
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    public enum CardStatus {
        ACTIVE, INACTIVE
    }

    @Column(name = "internationalpayment")
    @Enumerated(EnumType.STRING)
    private PaymentStatus internationalPayment;

    @Column(name = "onlinepayment")
    @Enumerated(EnumType.STRING)
    private PaymentStatus onlinePayment;

    public enum PaymentStatus {
        ENABLE, DISABLE
    }

    @Column(name = "cardbalance", precision = 10, scale = 4)
    private BigDecimal cardBalance;

    @Column(name = "dueamount", precision = 10, scale = 4)
    private BigDecimal dueAmount;

    @Column(name = "duedate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

//    @ManyToOne
//    @JoinColumn(name = "cardtype", referencedColumnName = "cardtype")
//    private Card cardType;
    
    @OneToOne
    @JoinColumn(name = "cardtype", referencedColumnName = "cardtype")
    private Card cardType;
}

