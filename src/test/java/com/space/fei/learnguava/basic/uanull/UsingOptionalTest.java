package com.space.fei.learnguava.basic.uanull;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsingOptionalTest {

    @Test
    public void compare() {
        UsingOptional usingOptional = new UsingOptional();
        String first = "abcde";
        String result = usingOptional.compare(first, null);

        if (result != null) {
            if (result.equalsIgnoreCase(first)) {
                System.out.println("First Win!!!");
            }
        }

    }

    @Test
    public void compareReturnOption() {
        UsingOptional usingOptional = new UsingOptional();
        String first = "abcde";
        Optional<String> result = usingOptional.compareReturnOption(first, null);
        if (result.isPresent()) {
            if (result.get().equalsIgnoreCase(first)) {
                System.out.println("First Win!!!");
            }
        }

    }

    @Test
    public void compareParamOption() {
        UsingOptional usingOptional = new UsingOptional();
        Optional<String> first = Optional.of("abcde");
        // 这种写法会导致运行出错
        // Optional<String> second = Optional.of(null);
        Optional<String> second = Optional.fromNullable(null);
        Optional<String> result = usingOptional.compareParamOption(first, second);
        if (result.isPresent()) {
            if (result.get().equalsIgnoreCase(first.get())) {
                System.out.println("First Win!!!");
            }
        }
    }

    @Test
    public void comparePersonName() {
        UsingOptional usingOptional = new UsingOptional();
        Optional<Person> alice = Optional.of(
                Person.newBuilder()
                .name(Optional.of("Alice"))
                .age(Optional.of(22))
                .build()
        );
        Optional<Person> bob = Optional.of(
                Person.newBuilder()
                        .name(Optional.of("Bob"))
                        .age(Optional.of(23))
                        .build()
        );
        Optional<Person> result = usingOptional.comparePersonName(alice, bob);
        if (result.isPresent()) {
            if (result.get().getName().get().equalsIgnoreCase(alice.get().getName().get())) {
                System.out.println("Alice Win!!!");
            } else {
                System.out.println("Bob Win!!!");
            }
        }
    }
}