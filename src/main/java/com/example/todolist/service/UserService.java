package com.example.todolist.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.todolist.entity.TodoList;
import com.example.todolist.entity.User;
import com.example.todolist.entity.dto.UpdateDto;

import java.util.List;
import java.util.Map;


public interface UserService extends IService<User> {


    Map<String, Object> login(User user);

    Map<String, Object> info();
}