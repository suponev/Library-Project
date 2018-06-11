package ru.library.entity.ids;

import lombok.Data;

import java.io.Serializable;

@Data
public class VoteId implements Serializable {
    private Long userId;
    private Long publicationId;
}
