package com.massoudafrashteh.code.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document
@ToString
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = -5854803851653922493L;

    @Id
    private String id;
    private String name;
    private long timestamp = new Date().getTime();
}