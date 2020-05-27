package com.jordansoares.entities;


import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotNull
    @Column(name="created")
    private String body;

    @NotNull
    @Column(name="created", updatable = false, insertable = false)
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    private Message nextMessage;

    public Message() {
    }

    public Message(String body, LocalDateTime created, User user) {
        this.body = body;
        this.created = created;
        this.user = user;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }
}
