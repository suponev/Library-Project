package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.library.entity.PublicationEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationResponse {

    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    private String text;
    private String username;
    @JsonProperty("image_id")
    private Long imageId;
    private String image;

    public static PublicationResponse fromEntity(PublicationEntity entity) {
        PublicationResponse response = new PublicationResponse();
        response.setText(entity.getText());
        response.setImage(entity.getImage().getBase64());
        response.setUserId(entity.getUser().getId());
        response.setUsername(entity.getUser().getUsername());
        return response;

    }


}
