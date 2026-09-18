package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DemoController
 * Package: com.example.demo.controller
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
@RestController()
@RequestMapping("/demo")
class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String sayHello(){
        List<SysUser> list = demoService.list();
        list.forEach(sysUser -> System.out.println(sysUser));
        return "hello world";
    }

    @GetMapping("/test")
    public String test(){
        demoService.test();
        return "hello world";
    }
}