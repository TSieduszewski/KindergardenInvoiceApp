package com.kindergarden.app.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kindergarden.app.util.PaymentValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonDeserialize(as = PaymentTermsImpl.class)
public abstract class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_terms")
    private UUID id;

    protected int basicTuitionPrice;

    protected int basicMealPrice;

    protected int mealCounter;

//    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private CityGrant cityGrant;

    @OneToOne(mappedBy = "paymentTerms", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private GrantFromLublinPack grantFromLublinPack;

    //    @OneToOne(mappedBy = "paymentTerms", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id", referencedColumnName = "id_pack")
    private SpecialPack specialPack = new SpecialPack();

    //    @OneToOne
//    @MapsId
//    @JoinColumn(name = "parent_id")
    @OneToOne(mappedBy = "paymentTerms")
    private Parent parent;

    public void setBasicTuitionPrice(int basicTuitionPrice) {
        this.basicTuitionPrice = PaymentValues.TUITION;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setSpecialPack(SpecialPack specialPack) {
        this.specialPack = specialPack;
    }

    public abstract void setBasicMealPrice(int basicMealPrice);

    public abstract void setMealCounter(int mealCounter);

}
