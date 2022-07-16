package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kindergarden.app.util.PaymentValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
    private UUID id;

    protected int basicTuitionPrice;

    protected int basicMealPrice;

    protected int mealCounter;


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
