package com.kindergarden.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantFromLublinPack {

    @Id
    @GeneratedValue
    private UUID id;

    private boolean grantFromLublin;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private PaymentTerms paymentTerms;
}
