package com.example.todolist.service.impl;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.domain.AjaxResult;
import com.example.todolist.entity.User;
import com.example.todolist.entity.UserDetail;
import com.example.todolist.mapper.UserDetailMapper;
import com.example.todolist.mapper.UserMapper;
import com.example.todolist.service.UserService;
import com.example.todolist.utils.JwtUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;


    @Resource
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailMapper userDetailMapper;

    public Map<String, Object> login(User userInput) {
        String code = userInput.getCode();
        log.info("---->>>>>>>微信登录参数：{}", userInput);


        if (code == null || code.isEmpty()) {
            return AjaxResult.error("code不能为空");
        }
        // 1. 调用微信接口
        String url = "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + appid +
                "&secret=" + secret +
                "&js_code=" + code +
                "&grant_type=authorization_code";

        String result = HttpUtil.get(url);
        JSONObject json = JSONUtil.parseObj(result);
        log.info("---->>>>>>>微信登录结果：{}", json);
        if (json.containsKey("errcode")) {
            throw new RuntimeException("微信登录失败：" + json.getStr("errmsg"));
        }

        String openid = json.getStr("openid");
        // String sessionKey = json.getStr("session_key"); // 按需使用

        // 2. 查找或创建用户
        User user = this.findByOpenid(openid);
        if (user == null) {
            user = new User();
            user.setOpenid(openid);
            user.setAvatarUrl(userInput.getAvatarUrl());
            user.setNickName(userInput.getNickName());
            this.save(user);
        }else{
            user.setAvatarUrl(userInput.getAvatarUrl());
            user.setNickName(userInput.getNickName());
            this.updateById(user);
        }


        // 3. 生成 token
        String token = jwtUtil.generateToken(user.getId(), openid);

        // 4. 返回结果
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("nickName", user.getNickName());
        userInfo.put("userName", user.getNickName());
        userInfo.put("avatarUrl", user.getAvatarUrl());
        userInfo.put("userId", user.getId());
        data.put("userInfo", userInfo);

        return data;
    }

    @Override
    public List<User>  info() {
        log.info("---->>>>>>>获取用户信息");
        LambdaQueryWrapper<User> query = Wrappers.lambdaQuery();
        List<User> list = this.list(query);
        log.info("---->>>>>>>用户信息：{}", list.size());
        if (list != null && list.size() > 0) {
            return list;
        }else {
            return null;
        }
    }

    @Override
    public List<UserDetail> detail() {
        log.info("---->>>>>>>获取用户信息");
        LambdaQueryWrapper<UserDetail> query = Wrappers.lambdaQuery();
        Page pageInfo = new Page(1, 10);
        Page page = userDetailMapper.selectPage(pageInfo, query);
        List<UserDetail> list = page.getRecords();
        log.info("---->>>>>>>用户信息：{}", list.size());
        if (list != null && list.size() > 0) {
            list.forEach(item ->{
                item.setMobile(item.getMobile().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
            });
            return list;
        }else {
            return null;
        }
    }

    @Override
    public String deleteDetail(String id) {

        log.info("---->>>>>>>删除用户信息:{}",id);
        userDetailMapper.delete(new LambdaQueryWrapper<UserDetail>().eq(UserDetail::getId, id));
        return "删除成功";
    }

    @Override
    public String updateDetail(UserDetail userDetail) {
        log.info("---->>>>>>>更新用户信息:{}",userDetail);
        userDetailMapper.updateById(userDetail);
        log.info("---->>>>>>>更新用户信息:{}",userDetail);
        return "更新用户信息成功";
    }

    private User findByOpenid(String openid) {
        LambdaQueryWrapper<User> query = Wrappers.lambdaQuery();
        query.eq(User::getOpenid, openid);
        return this.getOne(query);
    }


}
