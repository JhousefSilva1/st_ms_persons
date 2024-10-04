package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_person")
public class StPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_person_id")
    private Long idPerson;

    @Column(name = "st_person_name")
    private String personName;

    @Column(name = "st_person_surname")
    private String personSurname;

    @Column(name = "st_person_birthdate")
    private Date personBirthdate;

    @Column(name = "st_person_whatsapp_number")
    private String personWhatsappNumber;

    @ManyToOne
    @JoinColumn(name = "st_genders_st_gender_id", nullable = false)
    private StGenderEntity genders;


}
