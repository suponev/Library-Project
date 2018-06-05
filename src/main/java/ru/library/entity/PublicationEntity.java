package ru.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import ru.library.models.Publication;
import ru.library.models.PublicationRequest;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "images")
public class PublicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private UserEntity user;
    @OneToOne
    private ImageEntity image;

    @UpdateTimestamp
    @Column(name = "time_key")
    private LocalDateTime timeKey;

    public static PublicationEntity fromModel(PublicationRequest model) {
        PublicationEntity entity = new PublicationEntity();
        entity.setText(model.getText());
        entity.setUser(new UserEntity(model.getUserId()));
        entity.setImage(new ImageEntity(model.getImageId()));
        return entity;
    }
}
