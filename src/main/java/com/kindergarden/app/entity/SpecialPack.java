package com.kindergarden.app.entity;

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
public class SpecialPack{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pack")
    private UUID id;

    private boolean pack;

    @OneToOne(mappedBy = "specialPack")
    private PaymentTerms paymentTerms;
}
