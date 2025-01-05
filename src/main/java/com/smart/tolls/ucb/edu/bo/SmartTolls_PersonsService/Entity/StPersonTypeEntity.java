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
@Table(name = "st_person_type")
public class StPersonTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_person_type_id")
    private Long idPersonType;

    @Column(name = "st_person_type")
    private String personType;

    @JsonIgnore
    @OneToMany(mappedBy = "personsType", fetch = FetchType.LAZY)
    private List<StPersonEntity> persons;

    private Integer status;


    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.status = 1;
    }
}


