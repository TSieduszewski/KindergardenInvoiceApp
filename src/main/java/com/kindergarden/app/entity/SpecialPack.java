package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SpecialPack{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean pack;

    @OneToOne(mappedBy = "specialPack")
    @JsonIgnore
    private PaymentTerms paymentTerms;
}
