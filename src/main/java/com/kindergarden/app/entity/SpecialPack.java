package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kindergarden.app.util.PaymentValues;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SpecialPack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private boolean pack;

    @OneToOne(mappedBy = "specialPack")
    @JsonIgnore
    private PaymentTerms paymentTerms;
}
