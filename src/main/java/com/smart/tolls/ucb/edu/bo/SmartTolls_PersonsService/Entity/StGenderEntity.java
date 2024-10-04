package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_genders")
public class StGenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="st_gender_id")
    private Long idGender;

    @Column(name = "st_gender_name")
    private String genderName;

    @JsonIgnore
    @OneToMany(mappedBy = "genders", fetch = FetchType.LAZY)
    private List<StPersonEntity> persons;

}
