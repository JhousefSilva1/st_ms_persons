package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long idPersonType;
    private String personType;
    @JsonIgnore
    @OneToMany(mappedBy = "personType", fetch = FetchType.LAZY)
    private List<StPersonEntity> persons;
    private Integer personTypeStatus;
    @Embedded
    private Audit audit = new Audit();
    @PrePersist
    public void prePersist() {
        this.personTypeStatus = 1;
    }
}


