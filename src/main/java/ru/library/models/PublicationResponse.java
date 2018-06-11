package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.library.entity.PublicationEntity;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationResponse {

    @JsonProperty("publication_id")
    private Long publicationId;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("image_id")
    private Long imageId;
    private String text;
    @JsonProperty("time_key")
    private String timeKey;

    private Long rating;
    private Long yourRating;

    public static PublicationResponse fromEntity(PublicationEntity entity, Long userId) {
        PublicationResponse response = new PublicationResponse();
        response.setPublicationId(entity.getId());
        response.setText(entity.getText());
        response.setUserId(entity.getUserId());
        response.setImageId(entity.getImageId());
        //String time = entity.getTimeKey().replace(" ", "T");
        response.setTimeKey(entity.getTimeKey());
        if (entity.getVotes() != null) {
            response.setRating(
                    entity.getVotes().stream()
                            .map(vote -> vote.getVote())
                            .reduce((a, b) -> a + b).orElse(0L)

            );
            response.setYourRating(
                    entity.getVotes().stream()
                            .filter(vote -> vote.getUserId().equals(userId))
                            .map(vote -> vote.getVote())
                            .findFirst().orElse(0L)
            );
        } else {
            response.setRating(0L);
            response.setYourRating(0L);
        }
        return response;
    }

}
