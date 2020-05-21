package com.space.fei.learnguava.basic.precondition;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsingPreconditionsTest {

    @Test
    public void compare() {
        UsingPreconditions usingPreconditions = new UsingPreconditions();
        usingPreconditions.compare(null, "test");
    }

    @Test
    public void compareSimple() {
        UsingPreconditions usingPreconditions = new UsingPreconditions();
        usingPreconditions.compareSimple(null, "test");
    }
}