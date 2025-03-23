package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "st_person")
public class StPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    private String personName;
    private String personSurname;
    private LocalDate personBirthdate;
    private String personWhatsappNumber;

    @Column(nullable = false, unique = true)
    private String personEmail;

    private String personPassword;
    private String personDni;
    private String personAddress;
    private String personAge;

//    private Long idCountry;
//    private Long idCity;

    @ManyToOne
    @JoinColumn(name = "id_gender", nullable = false)
    private StGenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "id_person_type", nullable = false)

    private StPersonTypeEntity personType;


    private Integer personStatus;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.personStatus = 1;
    }
}
