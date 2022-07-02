package com.kindergarden.app.entities;

import com.kindergarden.app.prices.PaymentValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PaymentTerms{

    @Id
    @GeneratedValue
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

    @OneToOne(mappedBy = "paymentTerms", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SpecialPack specialPack;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Parent parent;

    public void setBasicTuitionPrice(int basicTuitionPrice) {
        this.basicTuitionPrice = PaymentValues.TUITION;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public abstract void setBasicMealPrice(int basicMealPrice);

    public abstract void setMealCounter(int mealCounter);

}
