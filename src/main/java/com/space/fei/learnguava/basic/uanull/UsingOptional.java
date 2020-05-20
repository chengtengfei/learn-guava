package com.space.fei.learnguava.basic.uanull;

import com.google.common.base.Optional;


/**
 * Created with IntelliJ IDEA.
 * Show how to use the {@code Optional} class offered by google guava
 * @author: tengfei.cheng
 * @since: 0.0.1
 */

public class UsingOptional {

    /**
     * 以自然顺序比较两个字符串并返回较大的字符串（若是字符串为null则返回null）
     */
    public String compare(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return null;
        }
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }
        return secondString;
    }

    /**
     * 以自然顺序比较两个字符串并返回较大的字符串
     */
    public Optional<String> compareReturnOption(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return Optional.fromNullable(null);
        }
        if (firstString.compareTo(secondString) >= 0) {
            return Optional.of(firstString);
        }
        return Optional.of(firstString);
    }

    /**
     * 以自然顺序比较两个字符串并返回较大的字符串
     */
    public Optional<String> compareParamOption(Optional<String> firstString, Optional<String> secondString) {
        if (!firstString.isPresent() || !secondString.isPresent()) {
            return Optional.fromNullable(null);
        }
        if (firstString.get().compareTo(secondString.get()) >= 0) {
            return firstString;
        }
        return secondString;
    }

    /**
     * 以自然顺序比较两个人名字并返回较大的人员
     */
    public Optional<Person> comparePersonName(Optional<Person> firstPerson, Optional<Person> secondPerson) {
        if (!firstPerson.isPresent() || !secondPerson.isPresent()) {
            return Optional.fromNullable(null);
        }
        if (!firstPerson.get().getName().isPresent() || !secondPerson.get().getName().isPresent()) {
            return Optional.fromNullable(null);
        }
        if (firstPerson.get().getName().get().compareTo(secondPerson.get().getName().get()) >= 0) {
            return firstPerson;
        }
        return secondPerson;
    }

}
