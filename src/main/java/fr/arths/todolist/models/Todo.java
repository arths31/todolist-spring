package fr.arths.todolist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Todo {
    @Id
    protected UUID id;
    protected String title;
    protected Boolean state;

    public Todo() {

    }

    public Todo(String title) {
        this.title = title;
        this.state = false;
        this.id = UUID.randomUUID();
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
