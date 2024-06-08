package com.example.Model;

//import javax.persistence.*;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    
    @Id
    @Column(name = "cardtype")
    private String cardType;

    @Column(name = "maxlimit", nullable = false, precision = 10, scale = 4)
    private BigDecimal maxLimit;

    @Column(name = "interest", nullable = false)
    private BigDecimal interest;

    @Column(name = "annualfee", nullable = false, precision = 10, scale = 4)
    private BigDecimal annualFee;
}

