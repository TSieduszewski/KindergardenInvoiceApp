package com.kindergarden.app.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue
    @Column(name="id_parent")
    private UUID idParent;

    private String firstName;

    private String lastName;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PaymentTerms paymentTerms;


}
