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

public class Borrow {
    private Long id;
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
