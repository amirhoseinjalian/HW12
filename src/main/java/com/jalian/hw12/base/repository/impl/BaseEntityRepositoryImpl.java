package com.jalian.hw12.base.repository.impl;
import com.jalian.hw12.base.domain.BaseEntity;
import com.jalian.hw12.base.repository.BaseEntityRepository;
import javax.persistence.EntityManager;
import java.util.List;
public abstract class BaseEntityRepositoryImpl <E extends BaseEntity<ID>, ID> implements BaseEntityRepository <E, ID> {
    protected final EntityManager entityManager;

    public BaseEntityRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<E> getEntityClass();

    public E save(E e) {
        if (e.getId() == null) {
            entityManager.persist(e);
            return e;
        } else {
            return entityManager.merge(e);
        }
    }

    @Override
    public E findById(ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName(),
                getEntityClass()
        ).getResultList();
    }

    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}