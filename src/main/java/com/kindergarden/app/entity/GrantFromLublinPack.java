package com.kindergarden.app.entity;

import com.kindergarden.app.util.PaymentValues;
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

    private int grantPrice = -PaymentValues.GRANT;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private PaymentTerms paymentTerms;
}
