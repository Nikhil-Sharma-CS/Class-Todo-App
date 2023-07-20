package org.example.ClassTodo.App.Service;

import org.example.ClassTodo.App.Model.Todo;
import org.example.ClassTodo.App.Repository.ITodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    ITodoRepo ITodoRepo;

    public List<Todo> getAll() {
        return ITodoRepo.findAll();
    }

    public List<Todo> getAllDone() {
        return ITodoRepo.findBytodoStatus(true);
    }

    public List<Todo> getAllUndone() {
        return ITodoRepo.findBytodoStatus(false);
    }

    public Todo getById(Integer id) {
        return ITodoRepo.findById(id).orElse(null);
    }

    public String updateStatus(boolean status, Integer id) {
        Todo todo = ITodoRepo.findById(id).orElse(null);

        if(todo == null)
        {
            return "Todo by Id not found";
        }
        else
        {
            todo.setTodoStatus(status);
            ITodoRepo.save(todo);
            return "Todo Status updated";
        }
    }

    public String deleteTodo(Integer id) {
        if(ITodoRepo.existsById(id))
        {
            ITodoRepo.deleteById(id);
            return "Todo deleted";
        }
        else
        {
            return "Todo by Id not found";
        }
    }

    public String addTodos(List<Todo> todos) {
        ITodoRepo.saveAll(todos);
        return "Todos Saved";
    }
}
