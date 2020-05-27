package com.jordansoares.entities;


import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity(name = "threads")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="first_message_id", nullable=false)
    private Message firstMessage;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @NotNull
    @Column(name="created")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalDateTime created;

    public Thread() {
    }

    public Thread(Message firstMessage, User owner, LocalDateTime created) {
        this.firstMessage = firstMessage;
        this.owner = owner;
        this.created = created;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(Message firstMessage) {
        this.firstMessage = firstMessage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
