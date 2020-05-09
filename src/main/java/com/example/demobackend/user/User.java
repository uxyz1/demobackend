package com.example.demobackend.user;

import com.example.demobackend.entry.Entry;
import com.example.demobackend.yorum.Yorum;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private boolean admin;

    @OneToMany(mappedBy = "user")
    private Set<Entry> enrtyList;

    @OneToMany(mappedBy = "user")
    private Set<Yorum> yorumList;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.admin = false;
    }


    public User(String username, long id) {

        this.username = username;
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Entry> getEnrtyList() {
        return enrtyList;
    }

    public void setEnrtyList(Set<Entry> enrtyList) {
        this.enrtyList = enrtyList;
    }


    public User(long id) {
        this.id = id;
    }

    public Set<Yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(Set<Yorum> yorumList) {
        this.yorumList = yorumList;
    }
}
