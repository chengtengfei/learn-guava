package com.space.fei.learnguava.basic.object;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person() {}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // return "Person{" +
        //         "name='" + name + '\'' +
        //         ", age=" + age +
        //         '}';
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.age);
        // return java.util.Objects.hash(this.name, this.age);
    }


    @Override
    public int compareTo(Person other) {
        return ComparisonChain.start()
                .compare(this.name, other.name)
                .compare(this.age, other.age, Ordering.natural().nullsLast())
                .result();
    }
}
