package com.kindergarden.app.entity;

import com.kindergarden.app.entity.position.Position;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate localDate;

    //TODO create invoice number generator
    private String invoiceNumber;

    private int dinnerCounter;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentExpire;

    @ManyToOne
    @JoinColumn(name = "id_parents")
    private Parent parent;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Position> positions;
}
