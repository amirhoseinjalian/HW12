package com.jalian.hw12.base.service;
import com.jalian.hw12.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
public interface BaseEntityService<E extends BaseEntity<ID>, ID> {
    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void delete(E e);
}