package fr.arths.todolist.repositories;

import fr.arths.todolist.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {

    List<Todo> findByOrderByStateAscCreatedOnDesc();

}
