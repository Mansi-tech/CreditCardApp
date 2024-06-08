package com.example.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Entity
@Table(name = "guest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    
    @Id
    @Column(name = "guestid")
    private Long guestId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mobilenumber", length = 15)
    private String mobileNumber;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 100)
    private String name;
}

