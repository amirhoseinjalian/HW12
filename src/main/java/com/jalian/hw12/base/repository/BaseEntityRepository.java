package com.jalian.hw12.base.repository;
import com.jalian.hw12.base.domain.BaseEntity;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
public interface BaseEntityRepository <E extends BaseEntity<ID>, ID> {
    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void delete(E e);

    EntityManager getEntityManager();
}
