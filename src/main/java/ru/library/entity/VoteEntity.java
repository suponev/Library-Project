package ru.library.entity;

import lombok.Data;
import ru.library.entity.ids.VoteId;
import ru.library.models.Vote;

import javax.persistence.*;

@Data
@Entity
@Table(name = "votes")
@IdClass(VoteId.class)
public class VoteEntity {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "publication_id")
    private Long publicationId;
    private Long vote;

    public static VoteEntity fromModel(Vote model) {
        VoteEntity entity = new VoteEntity();
        entity.setUserId(model.getUserId());
        entity.setPublicationId(model.getPublicationId());
        entity.setVote(model.getVote());
        return entity;
    }
}


