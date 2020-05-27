package com.jordansoares.dtos;

import java.time.LocalDateTime;

public class MessageDto {

    private Integer id;
    private String body;
    private Integer authorId;
    private Integer nextMessageId;
    private LocalDateTime created;

    public MessageDto() {
    }

    public MessageDto(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getNextMessageId() {
        return nextMessageId;
    }

    public void setNextMessageId(Integer nextMessageId) {
        this.nextMessageId = nextMessageId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
