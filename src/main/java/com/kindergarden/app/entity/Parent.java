package com.kindergarden.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_parent")
    private UUID id;

    private String firstName;

    private String lastName;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    //    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
//    //@NotNull
//    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "terms_id", referencedColumnName = "id_terms")
    private PaymentTerms paymentTerms;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Invoice> invoice;

}
