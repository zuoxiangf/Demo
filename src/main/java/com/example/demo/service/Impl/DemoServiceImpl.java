package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SysUser;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, SysUser>  implements DemoService {
}
