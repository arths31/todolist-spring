package fr.arths.todolist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Todo {
    @Id
    protected UUID id;
    protected String title;
    protected boolean state;

    protected String description;

    protected Date createdOn;

    public Todo() {

    }

    public Todo(String title) {
        this.title = title;
        this.state = false;
        this.id = UUID.randomUUID();
        this.description = null;
        this.createdOn = new Date();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
