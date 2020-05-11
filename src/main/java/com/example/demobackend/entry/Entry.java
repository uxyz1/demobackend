package com.example.demobackend.entry;

import com.example.demobackend.user.User;
import com.example.demobackend.yorum.Yorum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String name;

    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;



    @OneToMany
    @JoinColumn(name="yorum_id")
    @JsonIgnore
    private List<Yorum> yorumList;

    private Instant postedAt;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Yorum> getYorumList() {
        return yorumList;
    }

    public Entry() {
    }

    public Entry(String name) {
        this.name=name;
    }

    public Entry(User user,List<Yorum>yorumList){
        this.user=user;
        this.yorumList=yorumList;

    }


    public Entry(String name, User user) {
        this.name = name;
        this.user = user;
    }
    /*    public Entry( String name,long id) {
        try {
            var id1 = this.user.getId();
            id1 = id;
            this.name = name;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public Entry(String name, User user, List<Yorum> yorumList, Instant postedAt) {
        this.name = name;
        this.user = user;
        this.yorumList = yorumList;
        this.postedAt = postedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setYorumList(List<Yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public Instant getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Instant postedAt) {
        this.postedAt = postedAt;
    }

    public Entry( String name,long id) {
        this.id = id;
        this.name = name;
    }

    public Entry(String name, User user, Instant postedAt){

        this.name=name;
        this.user=user;
        this.postedAt=postedAt;
    }
}


