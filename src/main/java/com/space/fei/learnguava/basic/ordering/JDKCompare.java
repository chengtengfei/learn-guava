package com.space.fei.learnguava.basic.ordering;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JDKCompare {

    private void print(List<Student> studentList) {
        Preconditions.checkNotNull(studentList);
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 88));
        studentList.add(new Student("Bob", 92));
        studentList.add(new Student("Ceb", 70));
        studentList.add(new Student("David", 66));
        studentList.add(new Student("Benjamin", 90));

        JDKCompare jdkCompare = new JDKCompare();
        System.out.println("==============before compare=================");
        jdkCompare.print(studentList);
        System.out.println("==============after compare=================");
        Collections.sort(studentList);
        jdkCompare.print(studentList);

        Comparator<Student> nameCompare = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        System.out.println("==============after compare=================");
        // Collections.sort(studentList, nameCompare);
        studentList.sort(nameCompare);
        jdkCompare.print(studentList);

    }
}
