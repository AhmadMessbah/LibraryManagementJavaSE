package com.mftplus.model.mapper;

import com.mftplus.model.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
    public static Book map(ResultSet resultSet) throws SQLException {
        return Book
                .builder()
                .id(resultSet.getLong("BOOK_ID"))
                .title(resultSet.getString("BOOK_TITLE"))
                .author(resultSet.getString("BOOK_AUTHOR"))
                .build();
    }
}
