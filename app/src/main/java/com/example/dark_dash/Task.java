package com.example.dark_dash;

import java.io.Serializable;

public class Task implements Serializable {
    private long id;
    private String title;
    private String description;
    private Boolean status= true;

    public Task(){}
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public Boolean getStatus(){return status;}

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
