package com.mftplus.model.bl;

import com.mftplus.model.dao.BookDa;
import com.mftplus.model.entity.Book;
import lombok.Getter;

import java.util.List;

public class BookBl implements BusinessLogic<Book, Long> {
    @Getter
    private final static BookBl instance = new BookBl();
    private final BookDa bookDa = new BookDa();

    private BookBl() {
    }

    @Override
    public void save(Book book) throws Exception {
        bookDa.save(book);
    }

    @Override
    public void update(Book book) throws Exception {
        bookDa.update(book);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        bookDa.deleteById(id);
    }

    @Override
    public Book findById(Long id) throws Exception {
        return bookDa.findById(id);
    }

    @Override
    public List<Book> findAll() throws Exception {
        return bookDa.findAll();
    }
}
