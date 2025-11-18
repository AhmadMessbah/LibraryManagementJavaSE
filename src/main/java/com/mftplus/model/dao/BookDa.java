package com.mftplus.model.dao;

import com.mftplus.model.entity.Book;
import com.mftplus.model.mapper.BookMapper;
import com.mftplus.model.utils.ConnectionProvider;
import com.mftplus.model.utils.SqlCommands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDa implements DataAccessObject<Book, Long> {
    @Override
    public void save(Book book) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Book.BOOK_INSERT)
        ) {
            book.setId(ConnectionProvider.getInstance().getNextId("BOOK_SEQ"));
            preparedStatement.setLong(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.execute();
        }
    }

    @Override
    public void update(Book book) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Book.BOOK_UPDATE)
        ) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setLong(3, book.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Book.BOOK_DELETE)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }

    @Override
    public Book findById(Long id) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Book.BOOK_SELECT_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return BookMapper.map(resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() throws Exception {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Book.BOOK_SELECT_ALL)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = BookMapper.map(resultSet);
                bookList.add(book);
            }
        }
        return bookList;
    }
}
