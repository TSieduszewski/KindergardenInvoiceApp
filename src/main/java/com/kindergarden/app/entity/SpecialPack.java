package com.kindergarden.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SpecialPack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    private boolean pack;

    @OneToOne(mappedBy = "specialPack")
    @JsonIgnore
    private PaymentTerms paymentTerms;
}
