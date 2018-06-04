package ru.library.dao;

import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import ru.library.entity.UserEntity;
import ru.library.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<UserEntity> selectUserById(String username) {
        UserEntity result = (UserEntity) entityManager.createQuery("from UserEntity where username = :username")
                .setParameter("username", username).getSingleResult();
        return Optional.of(result);
    }

    public List<UserEntity> all() {
        return entityManager
                .createQuery("from UserEntity")
                .getResultList();
    }

}
