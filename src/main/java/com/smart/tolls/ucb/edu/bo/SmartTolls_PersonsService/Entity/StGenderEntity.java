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
    private Long idGender;
    private String genderName;
    @JsonIgnore
    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY)
    private List<StPersonEntity> persons;
    private Integer genderStatus;
    @Embedded
    private Audit audit = new Audit();
    @PrePersist
    public void prePersist() {
        this.genderStatus = 1;
    }
}
