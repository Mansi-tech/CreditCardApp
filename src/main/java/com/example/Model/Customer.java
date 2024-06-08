package com.example.Model;


//import javax.persistence.*;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    @Id
    @Column(name = "customerid")
    private Long customerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "pannumber", unique = true, nullable = false)
    private String panNumber;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "firstlogin", columnDefinition = "boolean default true")
    private Boolean firstLogin = true;

//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private GuestDetails guestDetails;
    
    @OneToMany(mappedBy = "customer")
    private List<CustomerAccount> customerAccounts;
}



