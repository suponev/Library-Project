package ru.library.services;

import org.springframework.stereotype.Service;
import ru.library.dao.PublicationDao;
import ru.library.entity.PublicationEntity;
import ru.library.models.Publication;
import ru.library.models.PublicationFilter;
import ru.library.models.PublicationRequest;
import ru.library.models.PublicationResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServise {
    private final PublicationDao publicationDao;

    public PublicationServise(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    public void savePublication(PublicationRequest value) {
        PublicationEntity entity = PublicationEntity.fromModel(value);
        publicationDao.save(entity);
    }

    public List<PublicationResponse> getByFilter(PublicationFilter filter) {
        return publicationDao.all().stream()
                .map(PublicationResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
