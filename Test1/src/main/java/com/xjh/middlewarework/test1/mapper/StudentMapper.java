package com.xjh.middlewarework.test1.mapper;

import com.xjh.middlewarework.test1.bean.Student;
import com.xjh.middlewarework.test1.bean.vo.StudentDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> listAllStudent();

    List<StudentDetails> listAllStudentDetails();

    int updateName(@Param("id") int id,@Param("name") String name);

    Student getStudentById(@Param("id") int id);
}
