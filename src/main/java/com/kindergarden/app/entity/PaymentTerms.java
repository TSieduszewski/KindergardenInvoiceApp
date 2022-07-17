package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kindergarden.app.util.PaymentValues;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Digits(message = "Tylko liczby", integer = 4, fraction = 0)
    private int basicTuitionPrice;

    @Digits(message = "Tylko liczby", integer = 4, fraction = 0)
    private int basicMealPrice;

    @Digits(message = "Tylko liczby", integer = 2, fraction = 0)
    private int mealCounter;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grant_id", referencedColumnName = "id")
    private GrantFromLublinPack grantFromLublinPack;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id", referencedColumnName = "id")
    private SpecialPack specialPack;

    @OneToOne(mappedBy = "paymentTerms")
    @JsonIgnore
    private Parent parent;

    public PaymentTerms() {
        this.basicTuitionPrice = PaymentValues.TUITION;
    }

    public void setBasicTuitionPrice(int basicTuitionPrice) {
        this.basicTuitionPrice = PaymentValues.TUITION;
    }

    public void setBasicMealPrice(int basicMealPrice) {
        this.basicMealPrice = basicMealPrice;
    }

    public void setMealCounter(int mealCounter) {
        this.mealCounter = mealCounter;
    }

    @PrePersist
    private void calculateBasicMealPrice() {
        if (specialPack.isPack()) {
            setBasicMealPrice(PaymentValues.PACK);
            setMealCounter(1);
        } else {
            if(basicMealPrice==0) {
                setBasicMealPrice(PaymentValues.MEAL);
            }
        }
    }
}
