package com.massoudafrashteh.code.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 6031430357957703812L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
}