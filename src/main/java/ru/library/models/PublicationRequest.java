package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {
    @JsonProperty("user_id")
    private Long userId;
    private String text;
    @JsonProperty("image")
    private String imageBase64;

}