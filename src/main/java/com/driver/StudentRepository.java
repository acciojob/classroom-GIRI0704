package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
@Repository
public class StudentRepository {

    HashMap<String,Student> student = new HashMap<>();
    HashMap<String,Teacher> teacher = new HashMap<>();

    HashMap<String,List<String>> studentTeacher = new HashMap<>();
    public void addStudent(String name,Student stud)
    {
        student.put(name,stud);
    }

    public void addTeacher(String name, Teacher teach)
    {
        teacher.put(name,teach);
    }

    public void addStudentTeacherPair(String student,String teacher)
    {
        if(studentTeacher.containsKey(teacher))
        {
            List<String> list = studentTeacher.get(teacher);
            list.add(student);
            studentTeacher.put(teacher,list);
        }
        else {
            List<String> list = new ArrayList<>();
            list.add(student);
            studentTeacher.put(teacher,list);
        }
    }

    public Student getStudentByName(String name)
    {
        return student.get(name);
    }

    public Teacher getTeacherByName(String name)
    {
        return teacher.get(name);
    }

    public List<String> getStudentsByTeacherName(String name)
    {
        return studentTeacher.get(name);
    }

    public List<String> getAllStudents()
    {
        List<String> list = new ArrayList<>();

        for(String key : student.keySet())
        {
            list.add(key);
        }
        return list;
    }

    public void deleteTeacherByName(String name) {
        teacher.remove(name);
        studentTeacher.remove(name);
    }

    public void deleteAllTeachers()
    {
        teacher.clear();
        student.clear();
        studentTeacher.clear();
    }
}
