package fr.arths.todolist;


import fr.arths.todolist.controllers.TodoController;
import fr.arths.todolist.forms.TodoCreateForm;
import fr.arths.todolist.forms.TodoUpdateForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoControllerTests {

    @Autowired
    private TodoController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void createTodo() {
        var noOfTodos = this.controller.list().size();
        var todo = this.controller.create(new TodoCreateForm("createTodo test", null));

        assertThat(todo.getTitle()).isEqualTo("createTodo test");
        assertThat(noOfTodos).isLessThan(this.controller.list().size());
    }

    @Test
    void updateTodo() {
        var todo = this.controller.list().get(0);
        var previousState = todo.getState();

        this.controller.update(todo.getId(), new TodoUpdateForm(!previousState));

        assertThat(this.controller.get(todo.getId()).get().getState()).isNotEqualTo(previousState);

    }

}
