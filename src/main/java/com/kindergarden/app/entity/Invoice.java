package com.kindergarden.app.entity;

import com.kindergarden.app.entity.position.Position;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private LocalDate localDate;

    //TODO create invoice number generator
    private String invoiceNumber;

    private String clientName;

    private String addressLine1;

    private String addressLine2;

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


    public void setClientName(String clientName) {

        this.clientName = (getClientName()==null) ? parent.getFirstName() + " " + parent.getLastName() : getClientName();
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = (getAddressLine1()==null) ? parent.getAddressStreet() : getAddressLine1();
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = (getAddressLine2()==null) ? parent.getAddressPostalCode() + " " + parent.getAddressCity() : getAddressLine2();
    }

}
