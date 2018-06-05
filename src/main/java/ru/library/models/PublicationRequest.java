package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    private String text;
    private String username;
    @JsonProperty("image_id")
    private Long imageId;

}