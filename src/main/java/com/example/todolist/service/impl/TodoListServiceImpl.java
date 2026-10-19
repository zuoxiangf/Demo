package com.example.todolist.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.todolist.entity.TodoList;
import com.example.todolist.entity.dto.UpdateDto;
import com.example.todolist.mapper.TodoListMapper;
import com.example.todolist.service.TodoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
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
    public List<TodoList> getList(String status, String userId) {
        LambdaQueryWrapper<TodoList> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotEmpty(status), TodoList::getStatus, status);
        queryWrapper.orderByDesc(TodoList::getCreateTime);
        List<TodoList> list = this.list(queryWrapper);
        return list;
    }

    @Override
    public String add(TodoList dto) {
        log.info("添加待办事项:入参：{}", dto);
        dto.setCreateTime(LocalDateTime.now());
        this.save(dto);
        return "添加成功";
    }

    @Override
    public Map<String, String> listCount(String userId) {
        log.info("查询待办事项总数:入参：{}", userId);
        LambdaQueryWrapper<TodoList> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotEmpty(userId), TodoList::getUserId, userId);
        queryWrapper.eq(TodoList::getDelFlag, 0);

        List<TodoList> list = this.list(queryWrapper);
        int total = list.size();
        long done = list.stream().filter(todoList -> todoList.getStatus().equals("1")).count();
        long undone = list.stream().filter(todoList -> todoList.getStatus().equals("0")).count();
        Map<String, String> map = Map.of("total", total + "", "done", done + "", "undone", undone + "");
        return map;
    }
}
