package com.example.todolist.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.todolist.entity.TodoList;
import com.example.todolist.entity.dto.UpdateDto;
import com.example.todolist.mapper.TodoListMapper;
import com.example.todolist.service.TodoListService;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;


@Service
public class TodoListServiceImpl extends ServiceImpl<TodoListMapper, TodoList> implements TodoListService {


    @Override
    public String updateContent(UpdateDto dto, Long id) {
        TodoList todoList = this.getById(id);
        todoList.setComment(dto.getComment());
        todoList.setTitle(dto.getTitle());
        this.updateById(todoList);
        return "更新成功";
    }

    @Override
    public String deleteById(Long id) {
        if (this.getById(id) == null) {
            return "不存在该待办事项";
        }
        this.removeById(id);
        return "删除成功";
    }

    @Override
    public String updateStatusById(Long id, String status) {
        TodoList todoList = this.getById(id);
        if (todoList == null) {
            return "不存在该待办事项";
        }

        todoList.setStatus(status);
        this.updateById(todoList);
        return "更新成功";
    }

    @Override
    public List<TodoList> getList(String status) {
        LambdaQueryWrapper<TodoList> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotEmpty(status),TodoList::getStatus, status);
        List<TodoList> list = this.list(queryWrapper);
        return list;
    }

    @Override
    public String add(TodoList dto) {
        this.save(dto);
        return "添加成功";
    }
}
