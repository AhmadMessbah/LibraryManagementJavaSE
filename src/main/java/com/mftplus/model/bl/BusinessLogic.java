package com.mftplus.model.bl;

import java.util.List;

public interface BusinessLogic<T, I>{
    void save(T t) throws Exception;
    void update(T t) throws Exception;
    void deleteById(I id) throws Exception;
    T findById(I id) throws Exception;
    List<T> findAll() throws Exception;
}
