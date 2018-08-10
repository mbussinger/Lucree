package com.lucree.mblacerda.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by marcus on 06/08/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableRecord {
    String id;
    String userId;
    String title;
    String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "\nTableRecord {" +
                "\n id=" + id +
                ",\n userId=" + userId +
                ",\n title=\'" + title + '\'' +
                ",\n body=\'" + body +
                "\n}";
    }
}