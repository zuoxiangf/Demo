package com.example.todolist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.todolist.entity.TodoList;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: TodoListMapper
 * Package: com.example.todolist.mapper
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */

@Mapper
public interface TodoListMapper extends BaseMapper<TodoList> {
}
