package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.Todo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoApi {
    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(String id) {
        return null;
    }

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public Todo update(String id, Todo todo) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
