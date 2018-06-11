package ru.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class PublicationFilter {
    private Long count;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("last_id")
    private String lastId;

    private Long index;


}
