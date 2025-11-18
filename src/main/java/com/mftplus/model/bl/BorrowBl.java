package com.mftplus.model.bl;

import com.mftplus.model.dao.BorrowDa;
import com.mftplus.model.entity.Borrow;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class BorrowBl implements BusinessLogic<Borrow, Long> {
    @Getter
    private final static BorrowBl instance = new BorrowBl();
    private final BorrowDa borrowDa = new BorrowDa();

    private BorrowBl() {
    }

    @Override
    public void save(Borrow borrow) throws Exception {
        borrowDa.save(borrow);
    }

    @Override
    public void update(Borrow borrow) throws Exception {
        borrowDa.update(borrow);
    }

    public void returnBookById(Long borrowId, LocalDate returnDate) throws Exception {
        borrowDa.returnBookById(borrowId, returnDate);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        borrowDa.deleteById(id);
    }

    @Override
    public Borrow findById(Long id) throws Exception {
        return borrowDa.findById(id);
    }

    @Override
    public List<Borrow> findAll() throws Exception {
        return borrowDa.findAll();
    }

    public List<Borrow> findByMemberId(Long memberId) throws Exception {
        return borrowDa.findByMemberId(memberId);
    }

    public List<Borrow> findReturned() throws Exception {
        return borrowDa.findReturned();
    }

    public List<Borrow> findUnreturned() throws Exception {
        return borrowDa.findUnreturned();
    }


    public List<Borrow> findByBookId(Long bookId) throws Exception {
        return borrowDa.findByBookId(bookId);
    }

    public List<Borrow> findUnreturnedByMemberId(Long memberId) throws Exception {
        return borrowDa.findUnreturnedByMemberId(memberId);
    }

    public Integer findCountByUnreturnedByMemberId(Long memberId) throws Exception {
        return borrowDa.findCountByUnreturnedByMemberId(memberId);
    }

    public List<Borrow> findByUnreturnedByBookId(Long bookId) throws Exception {
        return borrowDa.findUnreturnedByBookId(bookId);
    }
}