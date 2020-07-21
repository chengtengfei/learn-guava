package com.space.fei.learnguava.basic.exception;

import com.google.common.base.Throwables;

public class ClassifyException {

    private final static double THE_SECOND_SPEED = 11.2;

    public void flyToMoon(double speed) throws Exception {
        if (speed < 0) {
            throw new ParameterException("speed wrong");
        }
        if (speed >= THE_SECOND_SPEED) {
            System.out.println("fly to moon");
        } else {
            throw new PermissionException("speed too slow");
        }
    }

    public static String classifyException(Exception e) {
        if (e != null) {
            if (e instanceof ParameterException) {
                return "parameter";
            } else if (e instanceof PermissionException) {
                return "permission";
            } else {
                return e.getMessage();
            }
        }
        return "null";
    }

    public static void main(String[] args) throws Exception {
       ClassifyException classifyException = new ClassifyException();
       // try {
       //     classifyException.flyToMoon(1);
       // } catch (ParameterException e) {
       //     System.out.println("parameter");
       // } catch (PermissionException e) {
       //     System.out.println("permission");
       // } catch (Exception e) {
       //     System.out.println(e.getMessage());
       // }

       // try {
       //     classifyException.flyToMoon(1);
       // } catch (Exception e) {
       //     System.out.println(classifyException(e));
       // }

        // try {
        //     classifyException.flyToMoon(1);
        // } catch (ParameterException | PermissionException e) {
        //     System.out.println("self exception");
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        try {
            // classifyException.flyToMoon(1);
            int a = 0;
            int c = 2 / a;
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));;
            // Throwables.propagateIfPossible(e, ParameterException.class);
        }

        try {
            int a = 0;
            int c = 2 / a;
        } catch (Exception e) {
            Throwables.throwIfInstanceOf(e, ParameterException.class);
        }
    }
}
