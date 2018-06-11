package ru.library.services;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.library.dao.PublicationDao;
import ru.library.entity.ImageEntity;
import ru.library.entity.PublicationEntity;
import ru.library.entity.VoteEntity;
import ru.library.models.*;

import static com.google.common.base.Preconditions.checkArgument;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {
    private final PublicationDao publicationDao;

    public PublicationService(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    @Transactional
    public PublicationResponse savePublication(PublicationRequest value) throws IOException {
        checkArgument(value.getUserId().equals(getCurUser().getId()), "Not avalible!");
        ImageEntity imageEntity = new ImageEntity();
        byte[] data = DatatypeConverter.parseBase64Binary(
                value.getImageBase64().substring(value.getImageBase64().indexOf(",") + 1));
        imageEntity.setBytes(data);
        publicationDao.saveImage(imageEntity);

        PublicationEntity entity = PublicationEntity.fromModel(value);
        entity.setImageId(imageEntity.getId());
        entity.setTimeKey(LocalDateTime.now().toString());
        publicationDao.save(entity);
        return PublicationResponse.fromEntity(entity,value.getUserId());
    }

    @Transactional
    public List<PublicationResponse> getByFilter(PublicationFilter filter) {
        if (filter.getStartTime() == null) {
            filter.setStartTime(LocalDateTime.now().toString());
        }
        List<PublicationResponse> list = (List<PublicationResponse>) publicationDao.allByFilter(filter).stream()
                .map(entity -> PublicationResponse.fromEntity((PublicationEntity) entity, getCurUser().getId()))
                .collect(Collectors.toList());
        return list;
    }

    @Transactional
    public void vote(Vote vote) {
        checkArgument(vote.getUserId().equals(getCurUser().getId()), "Not avalible!");
        checkArgument(vote.getVote().equals(-1L) || vote.getVote().equals(1L));
        publicationDao.saveVote(VoteEntity.fromModel(vote));

    }

    @Transactional
    public ImageEntity getImage(Long id) {
        return publicationDao.getImageById(id);
    }

    @Transactional
    public User getCurUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }


}
