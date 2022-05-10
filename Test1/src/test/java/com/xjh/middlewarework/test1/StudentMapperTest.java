package com.xjh.middlewarework.test1;

import com.xjh.middlewarework.test1.mapper.StudentMapper;
import com.xjh.middlewarework.test1.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    private void printList(List<?> list){
        for (Object item : list){
            System.out.println(item);
        }
    }

    // 查询所有的学生信息
    @Test
    public void testSelectAll(){
        try(SqlSession session = MybatisUtils.getSqlSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            System.out.println("查询所有的学生信息");
            printList(mapper.listAllStudent());
        }
    }
    // 多表查询学生的详细信息
    @Test
    public void testSelectAllStudentDetails(){
        try(SqlSession session = MybatisUtils.getSqlSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            System.out.println("多表查询学生的详细信息：");
            printList(mapper.listAllStudentDetails());
        }
    }

    @Test
    public void updateName(){
        try(SqlSession session = MybatisUtils.getSqlSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            System.out.println("修改前：");
            System.out.println(mapper.getStudentById(201401001));
            mapper.updateName(201401001,"令狐冲");
            System.out.println("修改后：");
            System.out.println(mapper.getStudentById(201401001));
        }
    }

}
