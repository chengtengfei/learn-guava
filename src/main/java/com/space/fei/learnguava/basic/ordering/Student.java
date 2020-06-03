package com.space.fei.learnguava.basic.ordering;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;

public class Student implements Comparable<Student> {

    private String name;
    private Integer grade;

    public Student() {}

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(@Nullable Student other) {
        Preconditions.checkNotNull(other);
        return this.grade - other.grade;
    }
}
