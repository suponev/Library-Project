package ru.library.services;

import org.springframework.stereotype.Service;
import ru.library.dao.PublicationDao;
import ru.library.entity.PublicationEntity;
import ru.library.models.Publication;

@Service
public class PublicationServise {
    private final PublicationDao publicationDao;

    public PublicationServise(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    public void savePublication(Publication value) {
        PublicationEntity entity = PublicationEntity.fromModel(value);
        publicationDao.save(entity);
    }
}
