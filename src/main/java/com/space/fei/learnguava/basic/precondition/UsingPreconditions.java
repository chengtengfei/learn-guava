package com.space.fei.learnguava.basic.precondition;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Show how to use guava Preconditions
 * @author: tengfei.cheng
 * @since: 0.0.1
 */

public class UsingPreconditions {

    /**
     * 以自然顺序比较两个字符串并返回较大的字符串
     */
    public String compare(String firstString, String secondString) {
        if (firstString == null) {
            throw new NullPointerException("Argument 'firstString' expected non-null");
        }
        if (secondString == null) {
            throw new NullPointerException("Argument 'secondString' expected non-null");
        }
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }
        return secondString;
    }

    /**
     * 以自然顺序比较两个字符串并返回较大的字符串
     */
    public String compareSimple(String firstString, String secondString) {
        // Preconditions.checkNotNull(firstString, "Argument 'firstString' expected non-null", firstString, secondString);
        // Preconditions.checkArgument(firstString.length() > 5, "Argument 'firstString' expected length > 5", firstString, secondString);
        Preconditions.checkArgument(firstString != null && firstString.length() > 5, "Argument 'firstString' expected non-null and length > 5", firstString, secondString);
        // Objects.requireNonNull(secondString, "Argument 'secondString' expected non-null");
        Preconditions.checkNotNull(secondString, "Argument 'secondString' expected non-null");
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }
        return secondString;
    }

}
