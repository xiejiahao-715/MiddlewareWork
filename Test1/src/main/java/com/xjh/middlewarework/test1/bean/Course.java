package com.xjh.middlewarework.test1.bean;

import lombok.Data;

// 课程表
@Data
public class Course {
    // 课程id
    private String id;
    // 课程名称
    private String name;
    // 课程学时
    private int period;
    // 课程学分
    private int credit;
}
