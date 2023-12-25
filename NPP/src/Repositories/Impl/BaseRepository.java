package Repositories.Impl;

import Repositories.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseRepository<T> implements IRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<T> entityType;

    public BaseRepository(Class<T> entityType, EntityManager entityManager) {
        this.entityType = entityType;
    }

    @Override
    public void create(T item) {
        entityManager.persist(item);
    }

    @Override
    public void delete(int id) {
        T item = get(id);
        entityManager.remove(item);
    }

    @Override
    public T get(int id) {
        return entityManager.find(entityType, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityType);
        Root<T> root = query.from(entityType);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(T item) {
        entityManager.merge(item);
    }
}