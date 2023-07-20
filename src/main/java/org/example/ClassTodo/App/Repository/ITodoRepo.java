package org.example.ClassTodo.App.Repository;

import org.example.ClassTodo.App.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoRepo extends JpaRepository<Todo, Integer> {
    List<Todo> findBytodoStatus(boolean status);
}
