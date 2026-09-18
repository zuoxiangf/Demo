package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SysUser;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.net.URL;


@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, SysUser>  implements DemoService {


    public void test(){
        //getAbstractPath();//获取相对路径


    }




    void getAbstractPath(){
        //        //获取相对路径
        URL resource = DemoServiceImpl.class.getResource("/");
        System.out.println(resource);

        URL resource1 = this.getClass().getResource("/");
        System.out.println(resource1);
    }
}
