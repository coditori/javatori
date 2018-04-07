package com.massoudafrashteh.code.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Massoud Afrashteh on 9/18/17.
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -7384707918047162789L;

    private Long id;
    private String name;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
