package com.mftplus.model.dto;

import com.mftplus.model.entity.Borrow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class BorrowDto {
    private Long id;
    private String memberName;
    private String memberFamily;
    private String bookTitle;
    private String bookAuthor;
    private LocalDate borrowDate;


    public BorrowDto(Borrow borrow){
        id = borrow.getId();
        memberName = borrow.getMember().getName();
        memberFamily = borrow.getMember().getFamily();
        bookTitle = borrow.getBook().getTitle();
        bookAuthor = borrow.getBook().getAuthor();
        borrowDate = borrow.getBorrowDate();
    }
}
