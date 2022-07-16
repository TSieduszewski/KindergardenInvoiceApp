package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kindergarden.app.util.PaymentValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    protected int basicTuitionPrice;

    protected int basicMealPrice;

    protected int mealCounter;


    //    @OneToOne(mappedBy = "paymentTerms", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private GrantFromLublinPack grantFromLublinPack;
//
//    @OneToOne(mappedBy = "paymentTerms", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private SpecialPack specialPack = new SpecialPack();

    @OneToOne(mappedBy = "paymentTerms")
    @JsonIgnore
    private Parent parent;

//    public void setBasicTuitionPrice(int basicTuitionPrice) {
//        this.basicTuitionPrice = PaymentValues.TUITION;
//    }
//
//    public void setBasicMealPrice(int basicMealPrice) {
//        if (getSpecialPack().isPack()) {
//            this.basicMealPrice = PaymentValues.PACK;
//        } else {
//            this.basicMealPrice = PaymentValues.MEAL;
//        }
//    }
//
//    public void setMealCounter(int mealCounter) {
//        if (getSpecialPack().isPack()) {
//            this.mealCounter = 1;
//        } else {
//            this.mealCounter = mealCounter;
//        }
//    }

}
