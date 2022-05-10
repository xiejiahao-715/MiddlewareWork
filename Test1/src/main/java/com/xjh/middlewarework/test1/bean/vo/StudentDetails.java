package com.xjh.middlewarework.test1.bean.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

// 学生的详细信息
@Data
public class StudentDetails {
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
    // 学生班级名称
    private String className;
    // 学生每一门课程的详细信息
    private List<StudentCourse> courseList;
}
