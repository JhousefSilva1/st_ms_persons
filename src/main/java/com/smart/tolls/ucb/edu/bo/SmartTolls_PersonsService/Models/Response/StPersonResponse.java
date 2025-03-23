package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response;

import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StPersonResponse {
    private Long idPerson;
    private String personName;
    private String personSurname;
    private String personWhatsappNumber;
    private String personPassword;
    private String personDni;
    private LocalDate personBirthdate;
    private String personEmail;
    private String personAddress;
    private String personAge;
    private Integer personStatus;
    private GenderDTO gender;
    private PersonTypeDTO personType;

    public StPersonResponse(Long idPerson, String personSurname, String personDni, String personAddress, LocalDate personBirthdate, String personAge, String personEmail, String personPassword, GenderDTO gender, PersonTypeDTO personType) {
        this.idPerson = idPerson;
        this.personSurname = personSurname;
        this.personDni = personDni;
        this.personAddress = personAddress;
        this.personBirthdate = personBirthdate;
        this.personAge = personAge;
        this.personEmail = personEmail;
        this.personPassword = personPassword;
        this.gender = gender;
        this.personType = personType;
    }

    public static class GenderDTO {
        private Long idGender;
        private String genderName;

        public GenderDTO(Long idGender, String genderName) {
            this.idGender = idGender;
            this.genderName = genderName;
        }

//            setter and getter

        public Long getIdGender() {
            return idGender;
        }

        public void setIdGender(Long idGender) {
            this.idGender = idGender;
        }

        public String getGenderName() {
            return genderName;
        }

        public void setGenderName(String genderName) {
            this.genderName = genderName;


        }
    }

        public static class PersonTypeDTO {
            private Long idPersonType;
            private String personTypeName;

            public PersonTypeDTO(Long idPersonType, String personTypeName) {
                this.idPersonType = idPersonType;
                this.personTypeName = personTypeName;
            }

//            Setter and Getter

                public Long getIdPersonType() {
                    return idPersonType;
                }

                public void setIdPersonType(Long idPersonType) {
                    this.idPersonType = idPersonType;
                }

                public String getPersonTypeName() {
                    return personTypeName;
                }

                public void setPersonTypeName(String personTypeName) {
                    this.personTypeName = personTypeName;
                }
        }
    }
