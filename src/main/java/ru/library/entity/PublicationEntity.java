package ru.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.library.models.PublicationRequest;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "publications")
public class PublicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    private Long id;
    private String text;
    private Long userId;
    @Column(name = "image_id")
    private Long imageId;
    //@UpdateTimestamp
    @Column(name = "time_key")
    private String timeKey;

    public static PublicationEntity fromModel(PublicationRequest model) {
        PublicationEntity entity = new PublicationEntity();
        entity.setText(model.getText());
        entity.setUserId(model.getUserId());
        return entity;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id",updatable = false, insertable = false)
    private Set<VoteEntity> votes;
}
