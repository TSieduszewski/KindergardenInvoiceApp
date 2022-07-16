package com.kindergarden.app.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentTerms paymentTerms;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Invoice> invoice;


}
