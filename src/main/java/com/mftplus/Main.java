package com.mftplus;

import com.mftplus.model.bl.BookBl;
import com.mftplus.model.bl.BorrowBl;
import com.mftplus.model.bl.MemberBl;
import com.mftplus.model.dao.BorrowDa;
import com.mftplus.model.entity.Book;
import com.mftplus.model.entity.Borrow;
import com.mftplus.model.entity.Member;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        log.info("com.mftplus.App Started");

//        Member member = new Member("Ahmad", "Messbah");
//        MemberBl.getInstance().save(member);
//        System.out.println(MemberBl.getInstance().findAll());
//
//        Book book = new Book("JavaSE", "SCHILDT");
//        BookBl.getInstance().save(book);
//        System.out.println(BookBl.getInstance().findAll());
//
//        Borrow borrow =
//                Borrow
//                        .builder()
//                        .member(member)
//                        .book(book)
//                        .borrowDate(LocalDate.now())
//                        .build();
//
//        BorrowBl.getInstance().save(borrow);
//        System.out.println(BorrowBl.getInstance().findAll());
//
//        System.out.println(BorrowBl.getInstance().findCountByUnreturnedByMemberId(1L));
//        System.out.println(BorrowBl.getInstance().findByBookId(1L));

//        System.out.println(BorrowBl.getInstance().findReturned());
//        System.out.println(BorrowBl.getInstance().findUnreturned());

//        BorrowBl.getInstance().returnBookById(4L, LocalDate.now());

//        log.info("com.mftplus.App Closed");
    }
}
