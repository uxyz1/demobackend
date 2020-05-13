package com.example.demobackend.yorum;


import com.example.demobackend.entry.Entry;
import com.example.demobackend.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Yorum {

    private String text;

    public String getText() {
        return text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    @JsonIgnore
    private Entry entry;


    private Instant postedAt;

    public Yorum() {
    }

    public Yorum(String text, long id, Instant postedAt) {
        this.text = text;
        this.id = id;
        this.postedAt = postedAt;
    }

    public Yorum(String text, Entry entry, Instant postedAt) {
        this.text = text;
        this.entry = entry;
        this.postedAt=postedAt;


    }

    public Yorum(String text) {
        this.text = text;
    }

    public Yorum(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Yorum(String text, User user, Entry entry, Instant postedAt) {
        this.text = text;
        this.user = user;
        this.entry = entry;
        this.postedAt = postedAt;
    }

    public Yorum(String text, long id) {
        this.text = text;
        this.id=id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Instant postedAt) {
        this.postedAt = postedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
