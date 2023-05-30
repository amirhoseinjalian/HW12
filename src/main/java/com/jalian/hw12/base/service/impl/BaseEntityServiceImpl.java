package com.jalian.hw12.base.service.impl;

import com.jalian.hw12.base.domain.BaseEntity;
import com.jalian.hw12.base.repository.BaseEntityRepository;
import com.jalian.hw12.base.service.BaseEntityService;

import java.util.List;

public abstract class BaseEntityServiceImpl <E extends BaseEntity<ID>, ID, R extends BaseEntityRepository<E, ID>> implements BaseEntityService<E, ID> {

    protected final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        repository.getEntityManager().getTransaction().begin();
        e = repository.save(e);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public E findById(ID id) {
        repository.getEntityManager().getTransaction().begin();
        E e = repository.findById(id);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();
    }
}
