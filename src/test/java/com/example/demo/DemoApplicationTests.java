package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo.entity.SysUser;
import com.example.demo.mapper.DemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = demoMapper.selectList(null);
        Assert.isTrue(3 == userList.size(), "");
        userList.forEach(System.out::println);
    }


}


