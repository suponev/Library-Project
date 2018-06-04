package ru.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


public class AvatarEntity {
    private Long id;
    private byte[] bytes;
}
