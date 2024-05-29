package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(String id, User user) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
