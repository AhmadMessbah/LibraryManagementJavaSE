package com.mftplus.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder

public class Member {
    private Long id;
    private String name;
    private String family;
    private LocalDate birthDate;
    private Gender gender;
    private City city;

    public Member(String name, String family, LocalDate birthDate, Gender gender, City city) {
        this.name = name;
        this.family = family;
        this.birthDate = birthDate;
        this.gender = gender;
        this.city = city;
    }
}
