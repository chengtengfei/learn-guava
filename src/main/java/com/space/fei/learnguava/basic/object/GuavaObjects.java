package com.space.fei.learnguava.basic.object;

import com.google.common.base.Objects;


public class GuavaObjects {

    private void guavaEquals() {
        Person alice = new Person("alice", 18);
        Person bob = null;
        System.out.println(Objects.equal(alice, bob));
        System.out.println(java.util.Objects.equals(alice, bob));
    }

    private void compare() {
        Person alice = new Person("alice", 18);
        Person bob = new Person("alice", null);
        System.out.println(alice.compareTo(bob));
    }

    public static void main(String[] args) {
        GuavaObjects guavaObjects = new GuavaObjects();
        guavaObjects.guavaEquals();
        guavaObjects.compare();

        Person alice = new Person("alice", 18);
        System.out.println(alice.hashCode());
        System.out.println(alice);

    }
}
