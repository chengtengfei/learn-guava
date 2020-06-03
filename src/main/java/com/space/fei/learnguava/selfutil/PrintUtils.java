package com.space.fei.learnguava.selfutil;

public class PrintUtils {

    public String print(Object o) {
        String printMsg = "";
        if (isPrimitiveType(o)) {
            return o.toString();
        }
        return printMsg;
    }

    private boolean isPrimitiveType(Object o) {
        if (o instanceof String || o instanceof Boolean || o instanceof Integer || o instanceof Short
            || o instanceof Long || o instanceof Float || o instanceof Double || o instanceof Character) {
            return true;
        }
        return false;
    }
}
