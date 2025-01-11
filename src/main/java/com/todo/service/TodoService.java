package com.todo.service;


import com.todo.dto.TodoDTO;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoDTO(todo.getId(), todo.getTitle()))
                .collect(Collectors.toList());
    }


    public TodoDTO addTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoDTO(savedTodo.getId(), savedTodo.getTitle());
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
