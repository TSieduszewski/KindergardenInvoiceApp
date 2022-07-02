package com.kindergarden.app.entity.position;

import com.kindergarden.app.entity.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="position_type",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int basicValue;
    private int amount;
    private String description;
    private int total;

    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

}
