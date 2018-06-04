package ru.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.library.models.Publication;

import javax.persistence.*;
import java.io.IOException;

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

    public static PublicationEntity fromModel(Publication model) {
        PublicationEntity entity = new PublicationEntity();
        entity.setText(model.getText());
        entity.setUser(new UserEntity(model.getUserId()));
        entity.setImage(new ImageEntity(model.getImageId()));
        return entity;
    }
}
