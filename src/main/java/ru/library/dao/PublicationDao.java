package ru.library.dao;

import org.springframework.stereotype.Repository;
import ru.library.entity.PublicationEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PublicationDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(PublicationEntity entity) {
        entityManager.persist(entity);
    }

    public List<PublicationEntity> all() {
        return entityManager
                .createQuery("from PublicationEntity")
                .getResultList();
    }
}
