package com.mftplus.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder

public class Member {
    private Long id;
    private String name;
    private String family;

    public Member(String name, String family) {
        this.name = name;
        this.family = family;
    }
}
