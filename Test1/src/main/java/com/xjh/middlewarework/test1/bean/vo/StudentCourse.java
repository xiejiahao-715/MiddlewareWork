package com.xjh.middlewarework.test1.bean.vo;

import lombok.Data;

@Data
public class StudentCourse {
    // 课程id
    private String id;
    // 课程名称
    private String name;
    // 课程学时
    private int period;
    // 课程学分
    private int credit;
    // 课程成绩
    private int score;
}
