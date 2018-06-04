package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    private String text;
    private String username;
    @JsonProperty("image_id")
    private Long imageId;
}
