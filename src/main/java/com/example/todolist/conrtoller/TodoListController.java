package com.example.todolist.conrtoller;

import com.example.common.domain.AjaxResult;
import com.example.todolist.entity.TodoList;
import com.example.todolist.entity.dto.UpdateDto;
import com.example.todolist.service.TodoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ClassName: TodoListController
 * Package: com.example.TodoList.controller
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
@RestController()
@RequestMapping("/api/todo")
@Slf4j
class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/list")
    public AjaxResult list(@RequestParam(required = false) String status){
        return AjaxResult.success(todoListService.getList(status));
    }

    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id){
        return AjaxResult.success(todoListService.getById(id));
    }

    @PutMapping("/{id}")
    public AjaxResult updateById(@RequestBody UpdateDto dto,@PathVariable Long id){
        log.info("--------------->>>>>>>updateById: "+dto.toString());
        return AjaxResult.success(todoListService.updateContent(dto,id));
    }


    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable Long id){

        return AjaxResult.success(todoListService.deleteById(id));
    }

    @PutMapping("/{id}/status")
    public AjaxResult updateStatusById(@PathVariable Long id,@RequestBody UpdateDto dto){
        String status = dto.getStatus();
        return AjaxResult.success(todoListService.updateStatusById(id,status));
    }

    @PostMapping()
    public AjaxResult add(@RequestBody TodoList dto){
        return AjaxResult.success(todoListService.add(dto));
    }
}