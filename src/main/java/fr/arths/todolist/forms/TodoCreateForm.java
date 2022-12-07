package fr.arths.todolist.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TodoCreateForm(@JsonProperty(required = true) String title) {
}
