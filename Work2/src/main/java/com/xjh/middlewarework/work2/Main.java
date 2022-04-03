package com.xjh.middlewarework.work2;

import com.xjh.middlewarework.work2.bean.Student;
import com.xjh.middlewarework.work2.dao.StudentDao;
import com.xjh.middlewarework.work2.dao.impl.StudentDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.list();
        for(Student student : studentList){
            System.out.println(student);
        }
    }
}
