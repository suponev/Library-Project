package ru.library.dao;

import org.springframework.stereotype.Repository;
import ru.library.entity.ImageEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class FileDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long saveImage(ImageEntity entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    public Optional<ImageEntity> getImage(Long id) {
        String query = "from ImageEntity where id = :id";
        ImageEntity result = (ImageEntity) entityManager
                .createQuery(query)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.of(result);

    }

}
