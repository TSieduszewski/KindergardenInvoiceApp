package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kindergarden.app.util.PaymentValues;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class GrantFromLublinPack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private boolean grantFromLublin;

    private int grantPrice;

    @OneToOne(mappedBy = "grantFromLublinPack")
    @JsonIgnore
    private PaymentTerms paymentTerms;

    public void setGrantFromLublin(boolean grantFromLublin) {
        this.grantFromLublin = grantFromLublin;
        //zero number don't have any meaining - it requires for method start, because we want to set grant automaticly.
        //in setGrantPrice method we use boolean test to set values: 400 or 0. No other values are option.
        setGrantPrice(0);
    }

    public void setGrantPrice(int grantPrice) {
        this.grantPrice = isGrantFromLublin() ? -PaymentValues.GRANT : 0;
    }
}
