package com.example.todolist.conrtoller;

import com.example.common.domain.AjaxResult;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;
import kotlin.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.example.todolist.conrtoller
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
@RestController()
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user) {

        return AjaxResult.success(userService.login(user));
    }

    @GetMapping("/info")
    public AjaxResult info() {

        return AjaxResult.success(userService.info());
    }

}




