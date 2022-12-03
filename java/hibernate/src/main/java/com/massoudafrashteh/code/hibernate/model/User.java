package com.massoudafrashteh.code.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Massoud Afrashteh on 9/18/17.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
}
