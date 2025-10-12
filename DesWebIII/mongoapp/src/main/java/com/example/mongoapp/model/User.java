package com.example.mongoapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

    private String id;
    private String name;
    private String mail;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

}
