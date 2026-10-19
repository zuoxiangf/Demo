package com.example.todolist.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户详细信息实体类
 * 对应数据库表：wx_user
 */
@Data
@TableName("wx_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(exist = false)
    private String code;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别，1：男；2：女；0：未知
     */
    private String gender;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 状态（0在职 1离职）
     */
    private String status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号类型
     */
    private String accountType;

    /**
     * 入职时间
     */
    private LocalDateTime entryTime;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 删除状态(0:未删除，1:已删除)
     */
    @TableLogic
    private Integer delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}