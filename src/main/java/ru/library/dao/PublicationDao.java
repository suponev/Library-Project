package ru.library.dao;

import org.springframework.stereotype.Repository;
import ru.library.entity.ImageEntity;
import ru.library.entity.PublicationEntity;
import ru.library.entity.VoteEntity;
import ru.library.models.PublicationFilter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PublicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(PublicationEntity entity) {
        entityManager.persist(entity);
    }

    public List all() {
        return entityManager
                .createQuery("from PublicationEntity")
                .getResultList();
    }

    public List allByFilter(PublicationFilter filter) {
        String query = "from PublicationEntity ";
        if (filter.getLastId() != null) {
            query += "where publication_id  < :last_id ";

        }
        query += "ORDER BY publication_id DESC";
        Query q = entityManager.createQuery(query).setMaxResults(filter.getCount().intValue());
        if (filter.getLastId() != null) {
            q = q.setParameter("last_id", filter.getLastId());
        }
        return q.getResultList();
    }

    public void saveImage(ImageEntity entity) {
        entityManager.persist(entity);
    }

    public void saveVote(VoteEntity entity) {
        entityManager.merge(entity);
    }

    public ImageEntity getImageById(Long id) {
        return (ImageEntity) entityManager
                .createQuery("from ImageEntity where id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
