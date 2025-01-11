package com.todo.controller;


//import ch.qos.logback.core.model.Model;
import com.todo.dto.TodoDTO;
import org.springframework.ui.Model;
import com.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoViewController {

    private final TodoService todoService;

    public TodoViewController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @PostMapping
    public String addTodo(@RequestParam String title) {
        todoService.addTodo(new TodoDTO(null, title));
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/todos";
    }
}
