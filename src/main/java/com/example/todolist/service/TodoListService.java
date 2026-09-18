package com.example.todolist.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SysUser;
import com.example.todolist.entity.TodoList;
import com.example.todolist.entity.dto.UpdateDto;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TodoListService extends IService<TodoList> {


    String updateContent(UpdateDto dto, Long id);

    String deleteById(Long id);

    String updateStatusById(Long id, String status);

    List<TodoList> getList(String status);

    String add(TodoList dto);
}