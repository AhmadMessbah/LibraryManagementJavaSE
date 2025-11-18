package com.mftplus.model.dao;

import java.util.List;

public interface DataAccessObject <T, I>{
    void save(T t) throws Exception;
    void update(T t) throws Exception;
    void deleteById(I id) throws Exception;
    T findById(I id) throws Exception;
    List<T> findAll() throws Exception;
}
