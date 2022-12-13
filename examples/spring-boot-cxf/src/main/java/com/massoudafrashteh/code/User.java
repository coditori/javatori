package com.massoudafrashteh.code;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName, lastName;
}