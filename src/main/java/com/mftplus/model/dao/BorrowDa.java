package com.mftplus.model.dao;

import com.mftplus.model.entity.Borrow;
import com.mftplus.model.mapper.BorrowMapper;
import com.mftplus.model.utils.ConnectionProvider;
import com.mftplus.model.utils.SqlCommands;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowDa implements DataAccessObject<Borrow, Long> {
    @Override
    public void save(Borrow borrow) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_INSERT)
        ) {
            borrow.setId(ConnectionProvider.getInstance().getNextId("BORROW_SEQ"));
            preparedStatement.setLong(1, borrow.getId());
            preparedStatement.setLong(2, borrow.getMember().getId());
            preparedStatement.setLong(3, borrow.getBook().getId());
            preparedStatement.setDate(4, (borrow.getBorrowDate() == null) ? null : Date.valueOf(borrow.getBorrowDate()));
            preparedStatement.setDate(5, (borrow.getReturnDate()) == null ? null : Date.valueOf(borrow.getReturnDate()));
            preparedStatement.execute();
        }
    }

    @Override
    public void update(Borrow borrow) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_UPDATE)
        ) {
            preparedStatement.setLong(1, borrow.getMember().getId());
            preparedStatement.setLong(2, borrow.getBook().getId());
            preparedStatement.setDate(3, (borrow.getBorrowDate() == null) ? null : Date.valueOf(borrow.getBorrowDate()));
            preparedStatement.setDate(4, (borrow.getReturnDate()) == null ? null : Date.valueOf(borrow.getReturnDate()));
            preparedStatement.setLong(5, borrow.getId());
            preparedStatement.execute();
        }
    }

    public void returnBookById(Long borrowId, LocalDate returnDate) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_RETURN_BOOK_BY_ID)
        ) {
            preparedStatement.setDate(1, Date.valueOf(returnDate));
            preparedStatement.setLong(2, borrowId);
            preparedStatement.execute();
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_DELETE)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }

    @Override
    public Borrow findById(Long id) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return BorrowMapper.map(resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Borrow> findAll() throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_ALL)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public List<Borrow> findByMemberId(Long memberId) throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_BY_MEMBER_ID)
        ) {
            preparedStatement.setLong(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public List<Borrow> findByBookId(Long bookId) throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_BY_BOOK_ID)
        ) {
            preparedStatement.setLong(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public List<Borrow> findReturned() throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_RETURNED)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public List<Borrow> findUnreturned() throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_UNRETURNED)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public List<Borrow> findUnreturnedByMemberId(Long memberId) throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_UNRETURNED_BY_MEMBER_ID)
        ) {
            preparedStatement.setLong(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public Integer findCountByUnreturnedByMemberId(Long memberId) throws Exception {
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_COUNT_UNRETURNED_BY_MEMBER_ID)
        ) {
            preparedStatement.setLong(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("UNRETURNED_COUNT");
        }
    }

    public List<Borrow> findUnreturnedByBookId(Long bookId) throws Exception {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Borrow.BORROW_SELECT_UNRETURNED_BY_BOOK_ID)
        ) {
            preparedStatement.setLong(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Borrow borrow = BorrowMapper.map(resultSet);
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }
}
