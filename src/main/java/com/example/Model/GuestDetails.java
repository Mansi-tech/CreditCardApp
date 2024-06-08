package com.example.Model;


//import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guestdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestDetails {
    //moral problem, if someone hijacked pan number....
    @Id
    @Column(name = "guestDetailsId")
    private String guestDetailsId;
    
    @Column(name = "pannumber")
    private String panNumber;

    @Column(name = "aadharnumber", nullable = false)
    private Long aadhaarNumber;

    @Column(name = "firstname", length = 100)
    private String firstName;

    @Column(name = "lastname", length = 100)
    private String lastName;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "mobilenumber", length = 10)
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "guestid", referencedColumnName = "guestid", nullable = false)
    private Guest guest;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "employmentyears", nullable = false)
    private Integer employmentYears;

    @Column(name = "ispresentlyemployed", nullable = false)
    private Boolean isPresentlyEmployed;

    @Column(name = "companyname", length = 100)
    private String companyName;

    @Column(name = "annualincome")
    private BigDecimal annualIncome;

    @Column(name = "incomeprooffile", length = 255)
    private String incomeProofFile;

    @OneToOne
    @JoinColumn(name = "cardtype", referencedColumnName = "cardtype")
    private Card cardType;

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "pannumber")
//    private Customer customer;
}


