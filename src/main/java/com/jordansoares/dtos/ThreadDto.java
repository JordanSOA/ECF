package com.jordansoares.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ThreadDto {

    private Integer id;
    private Integer firstMessageId;
    private Integer ownerId;
    private LocalDateTime created;

    public ThreadDto() {
    }

    public ThreadDto(Integer firstMessageId, Integer ownerId, LocalDateTime created) {
        this.firstMessageId = firstMessageId;
        this.ownerId = ownerId;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstMessageId() {
        return firstMessageId;
    }

    public void setFirstMessageId(Integer firstMessageId) {
        this.firstMessageId = firstMessageId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
