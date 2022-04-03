package com.xjh.middlewarework.work2.dao.impl;

import com.xjh.middlewarework.work2.bean.Student;
import com.xjh.middlewarework.work2.connection.MySqlConnection;
import com.xjh.middlewarework.work2.dao.StudentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> list() {
        String sql = "select id,name,age from student";
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                studentList.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
}
