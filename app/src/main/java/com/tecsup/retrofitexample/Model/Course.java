package com.tecsup.retrofitexample.Model;

public class Course {
    private int id;
    private String name;
    private String course_code;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse_code() {
        return course_code;
    }

    //Add Period

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course_code='" + course_code + '\'' +
                '}';
    }
}
