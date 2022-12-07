package fr.arths.todolist.controllers;

import fr.arths.todolist.forms.TodoUpdateForm;
import fr.arths.todolist.models.Todo;
import fr.arths.todolist.repositories.TodoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostConstruct
    public void construct() {
        var hello = new Todo("Hello");
        hello.setState(true);
        hello.setDescription("world");

        this.todoRepository.save(hello);
        this.todoRepository.save(new Todo("Test"));
    }

    @GetMapping
    private Iterable<Todo> list() {
        return this.todoRepository.findByOrderByStateAsc();
    }

    @GetMapping("/{id}")
    private Optional<Todo> get(@PathVariable("id") UUID id) {
        return this.todoRepository.findById(id);
    }

    @PatchMapping("/{id}")
    private Optional<Todo> update(@PathVariable("id") UUID id, @RequestBody TodoUpdateForm form) {
        var todo = this.todoRepository.findById(id);

        if (todo.isPresent()) {
            if (form.state() != null) {
                todo.get().setState(form.state());
            }
            this.todoRepository.save(todo.get());
        }

        return todo;
    }

}
