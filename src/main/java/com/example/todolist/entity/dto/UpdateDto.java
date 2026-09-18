package com.example.todolist.entity.dto;

import lombok.Data;

/**
 * ClassName: UpdateDto
 * Package: com.example.todolist.entity.dto
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
@Data
public class UpdateDto {

    private Long id;
    private String title;
    private String comment;
    private String status;
}
