package com.space.fei.learnguava.basic.uanull;

import com.google.common.base.Optional;

public class Person {

    private Optional<String> name;
    private Optional<Integer> age;

    private Person(Builder builder) {
        setName(builder.name);
        setAge(builder.age);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }


    public static final class Builder {
        private Optional<String> name;
        private Optional<Integer> age;

        private Builder() {
        }

        public Builder name(Optional<String> val) {
            name = val;
            return this;
        }

        public Builder age(Optional<Integer> val) {
            age = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
