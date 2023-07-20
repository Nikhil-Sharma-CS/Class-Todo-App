package org.example.ClassTodo.App.Controller;

import org.example.ClassTodo.App.Model.Todo;
import org.example.ClassTodo.App.Service.TodoService;
import org.hibernate.annotations.GeneratedColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    //Get Mappings
    @GetMapping("todos")
    List<Todo> getAllTodos()
    {
        return todoService.getAll();
    }

    @GetMapping("getAllDone")
    List<Todo> getAllDone()
    {
        return todoService.getAllDone();
    }

    @GetMapping("getAllUndone")
    List<Todo> getAllUndone()
    {
        return todoService.getAllUndone();
    }

    @GetMapping("getById/{Id}")
    Todo getById(@PathVariable Integer Id)
    {
        return todoService.getById(Id);
    }

    @PostMapping("addTodos")
    String addTodos(@RequestBody List<Todo> todos)
    {
        return todoService.addTodos(todos);
    }

    //Put mapping
    @PutMapping("updateStatus/{status}")
    String updateStatus(@PathVariable boolean status, Integer Id)
    {
        return todoService.updateStatus(status, Id);
    }

    @DeleteMapping("deleteTodo/{Id}")
    String deleteTodo(@PathVariable Integer Id)
    {
        return todoService.deleteTodo(Id);
    }
}
