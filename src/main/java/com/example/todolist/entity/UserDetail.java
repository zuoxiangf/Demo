package com.example.todolist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户详细信息实体类
 * 对应数据库表：cscp_user_detail
 */
@Data
@TableName("cscp_user_detail")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓
     */
    private String familyName;

    /**
     * 名
     */
    private String name;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String imgPath;

    /**
     * 最后一次登陆时间
     */
    private LocalDateTime lastLogin;

    /**
     * 标题
     */
    private String discTitle;

    /**
     * 详细信息
     */
    private String discDetail;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 员工工号
     */
    private String userWorkno;

    /**
     * 身份证号
     */
    private String userCardno;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 职务
     */
    private String position;

    /**
     * 人脸图片
     */
    private String faceImgPath;

    /**
     * 员工类型
     */
    private String staffType;

    /**
     * 排序
     */
    private Integer orderby;
}
