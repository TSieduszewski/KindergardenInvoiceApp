package com.kindergarden.app.entities;

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
@AllArgsConstructor
public class CityGrant {

    @Id
    @GeneratedValue
    private UUID idCityGrant;
    private boolean grant;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_city_grant")
    private PaymentTerms paymentTerms;

}
