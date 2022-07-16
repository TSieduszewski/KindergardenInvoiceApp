package com.kindergarden.app.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
//    @NotBlank(message = "Pole nie może być puste, lub go brakować")
//    @Size(min=2, max=30, message = "Imię musi zawierać 2-30 znaków")
    private String firstName;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
//    @NotBlank(message = "Pole nie może być puste, lub go brakować")
//    @Min(value = 2, message = "Pole musi zawierać minimum 2 znaki")
    private String lastName;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
//    @NotBlank(message = "Pole nie może być puste, lub go brakować")
//    @Size(min=2, max=50, message = "Imię musi zawierać 2-50 znaków")
    private String addressStreet;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
//    @NotBlank(message = "Pole nie może być puste, lub go brakować")
//    @Size(min=2, max=30, message = "Imię musi zawierać 2-30 znaków")
    private String addressCity;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
//    @NotBlank(message = "Pole nie może być puste, lub go brakować")
//    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Poprawny format kodu pocztowego to: XX-XXX (np. 12-345)")
    private String addressPostalCode;

//    @NotNull(message = "Pole nie może być puste, lub go brakować")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentTerms paymentTerms;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Invoice> invoice;


}
