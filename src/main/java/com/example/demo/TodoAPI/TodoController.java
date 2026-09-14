package com.example.demo.TodoAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    // composition: instance of other classes present in other class
    private TodoService todoService;

    private final List<Todo> todos = new ArrayList<>();

    public TodoController(TodoService todoService) {
        this.todoService=todoService;
        todos.add(new Todo(true, 1, "Write Blog", 123));
        todos.add(new Todo(false, 2, "Do exercise", 345));
    }

    @GetMapping
    @TimeMonitor
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false, defaultValue = "false" ) Boolean isCompleted) throws InterruptedException {
        System.out.println("isCompleted:"+isCompleted);
        // Thread.sleep(2000);
        return ResponseEntity.ok(todos);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Integer todoId) {

        for (Todo todo : todos) {
            if (Objects.equals(todo.getId(), todoId)) {
                return ResponseEntity.ok(todo);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo) {

        todos.add(newTodo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newTodo);
    }


    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(
            @PathVariable Integer todoId) {

        for (int i = 0; i < todos.size(); i++) {

            if (Objects.equals(todos.get(i).getId(), todoId)) {

                todos.remove(i);

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }


    @PatchMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoById(
            @PathVariable Integer todoId,
            @RequestBody Todo updatedTodo) {

        for (Todo todo : todos) {

            if (Objects.equals(todo.getId(), todoId)) {

                if (updatedTodo.getTitle() != null) {
                    todo.setTitle(updatedTodo.getTitle());
                }

                if (updatedTodo.getUserId() != null) {
                    todo.setUserId(updatedTodo.getUserId());
                }

                if (updatedTodo.getCompleted() != null) {
                    todo.setCompleted(updatedTodo.getCompleted());
                }

                return ResponseEntity.ok(todo);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Integer todoId,
            @RequestBody Todo updatedTodo) {

        for (int i = 0; i < todos.size(); i++) {

            Todo todo = todos.get(i);

            if (Objects.equals(todo.getId(), todoId)) {

                updatedTodo.setId(todoId);

                todos.set(i, updatedTodo);

                return ResponseEntity.ok(updatedTodo);
            }
        }

        return ResponseEntity.notFound().build();
    }
}