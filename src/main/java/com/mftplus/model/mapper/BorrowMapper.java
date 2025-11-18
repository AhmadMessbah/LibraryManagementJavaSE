package com.mftplus.model.mapper;

import com.mftplus.model.entity.Book;
import com.mftplus.model.entity.Borrow;
import com.mftplus.model.entity.Member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowMapper {
    public static Borrow map(ResultSet resultSet) throws SQLException {
        Member member = MemberMapper.map(resultSet);
        Book book = BookMapper.map(resultSet);

        Date borrowDate = resultSet.getDate("BORROW_DATE");
        Date returnDate = resultSet.getDate("RETURN_DATE");

        return
                Borrow
                        .builder()
                        .id(resultSet.getLong("BORROW_ID"))
                        .member(member)
                        .book(book)
                        .borrowDate((borrowDate == null) ? null : borrowDate.toLocalDate())
                        .returnDate((returnDate == null) ? null : returnDate.toLocalDate())
                        .build();
    }
}
