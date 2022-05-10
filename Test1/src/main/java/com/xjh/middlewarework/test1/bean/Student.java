package com.xjh.middlewarework.test1.bean;

import lombok.Data;

import java.util.Date;

// 学生
@Data
public class Student {
    // 学生id
    private int id;
    // 学生姓名
    private String name;
    // 学生性别
    private String sex;
    // 学生出生日期
    private Date birthday;
    // 学生班级id
    private int classId;

}
