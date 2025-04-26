package com.citizens.citizensapi.primary.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "citizens")
@Data
public class Citizens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "resident_district", nullable = false)
    private Integer residentDistrict;

    @Column(name = "aadhar_id", length = 16)
    private String aadharId;

    @Enumerated(EnumType.STRING)
    private Caste caste;

    @Column(name = "is_nri")
    private Boolean isNri;

    @Column(name = "is_alive")
    private Boolean isAlive;

    private LocalDate dob;

    @Column(name = "mother_tongue")
    private String motherTongue;

    public enum Gender {
        Male, Female
    }

    public enum Caste {
        OC, BC, MBC, SC, ST
    }
}