package fr.arths.todolist.controllers;

import fr.arths.todolist.models.Todo;
import fr.arths.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    private Iterable<Todo> list() {
        return this.todoRepository.findAll();
    }


}
