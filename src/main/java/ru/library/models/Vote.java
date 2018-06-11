package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Vote {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("publication_id")
    private Long publicationId;
    private Long vote;

}
