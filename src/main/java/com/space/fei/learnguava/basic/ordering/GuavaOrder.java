package com.space.fei.learnguava.basic.ordering;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GuavaOrder {

    private void print(List<PureStudent> studentList) {
        Preconditions.checkNotNull(studentList);
        for (PureStudent student : studentList) {
            System.out.println(student.toString());
        }
    }

    private Function sortFunction = new Function<PureStudent, Comparable>() {
        @Nullable
        @Override
        public Comparable apply(@Nullable PureStudent pureStudent) {
            return pureStudent.getName();
        }
    };

    private Comparator<PureStudent> gradeComparator = new Comparator<PureStudent>() {
        @Override
        public int compare(PureStudent o1, PureStudent o2) {
            return o1.getGrade() - o2.getGrade();
        }
    };

    private List<PureStudent> generateStudent() {
        List<PureStudent> studentList = new ArrayList<>();
        studentList.add(new PureStudent("Alice", 88));
        studentList.add(new PureStudent("Bob", 92));
        studentList.add(new PureStudent("Ceb", 70));
        studentList.add(new PureStudent("David", 66));
        studentList.add(new PureStudent("Benjamin", 90));
        studentList.add(new PureStudent("David", 63));
        return studentList;
    }

    public void defaultOrdering() {
        System.out.println("====================order:default===============");
        Ordering<PureStudent> ordering = new Ordering<PureStudent>() {
            @Override
            public int compare(@Nullable PureStudent s1, @Nullable PureStudent s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        List<PureStudent> pureStudents = generateStudent();
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='Benjamin', grade=90}
            Student{name='Bob', grade=92}
            Student{name='Ceb', grade=70}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
         */
    }

    public void naturalOrdering() {
        System.out.println("====================order:natural===============");
        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.natural().onResultOf(sortFunction);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='Benjamin', grade=90}
            Student{name='Bob', grade=92}
            Student{name='Ceb', grade=70}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
         */
    }
    public void usingToStringOrdering() {
        System.out.println("====================order:usingToString===============");
        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.usingToString().onResultOf(sortFunction);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='Benjamin', grade=90}
            Student{name='Bob', grade=92}
            Student{name='Ceb', grade=70}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
         */
    }

    public void allEqualOrdering() {
        System.out.println("====================order:allEqual===============");
        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.allEqual().onResultOf(sortFunction);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='Bob', grade=92}
            Student{name='Ceb', grade=70}
            Student{name='David', grade=66}
            Student{name='Benjamin', grade=90}
            Student{name='David', grade=63}
         */
    }

    public void arbitraryOrdering() {
        System.out.println("====================order:arbitrary===============");
        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.arbitrary().onResultOf(sortFunction);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Alice', grade=88}
            Student{name='Ceb', grade=70}
            Student{name='Benjamin', grade=90}
            Student{name='Bob', grade=92}
         */
    }

    public void fromOrdering() {
        System.out.println("====================order:from===============");

        Comparator<PureStudent> nameComparator = new Comparator<PureStudent>() {
            @Override
            public int compare(PureStudent o1, PureStudent o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.from(nameComparator);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
            Student{name='Benjamin', grade=90}
            Student{name='Alice', grade=88}
         */
    }

    public void explicitOrdering() {
        System.out.println("====================order:explicit===============");

        List<PureStudent> studentList = generateStudent();

        List<String> stringList = Arrays.asList("Alice", "David", "Benjamin", "Ceb", "Bob");
        // Ordering<PureStudent> explicitOrdering = Ordering.explicit(stringList).nullsFirst().onResultOf(sortFunction).compound(gradeComparator);
        Ordering<PureStudent> explicitOrdering = Ordering.explicit(stringList).onResultOf(sortFunction);
        studentList.sort(explicitOrdering);
        print(studentList);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Benjamin', grade=90}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
         */

        Ordering<PureStudent> explicitOrdering2 = Ordering.explicit("David","Alice", "Benjamin", "Ceb", "Bob" ).onResultOf(sortFunction);
        studentList.sort(explicitOrdering2);
        System.out.println("--------------------------------------------");
        print(studentList);

        // output:
        /*
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Alice', grade=88}
            Student{name='Benjamin', grade=90}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
         */
    }

    public void chainOrdering() {
        System.out.println("====================order:chain===============");

        List<PureStudent> studentList = generateStudent();
        studentList.add(new PureStudent(null, 70));

        Ordering<PureStudent> ordering = Ordering.natural().nullsFirst().reverse().onResultOf(sortFunction);
        studentList.sort(ordering);
        print(studentList);

        // output: nullsFirst().reverse()
        /*
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
            Student{name='Benjamin', grade=90}
            Student{name='Alice', grade=88}
            Student{name='null', grade=70}
         */

        Ordering<PureStudent> ordering2 = Ordering.natural().reverse().nullsFirst().onResultOf(sortFunction);
        studentList.sort(ordering2);
        System.out.println("--------------------------------------------");
        print(studentList);

        // output: reverse().nullsFirst()
        /*
            Student{name='null', grade=70}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
            Student{name='Benjamin', grade=90}
            Student{name='Alice', grade=88}
         */

        Ordering<PureStudent> ordering3 = Ordering.natural().nullsLast().reverse().onResultOf(sortFunction);
        studentList.sort(ordering3);
        System.out.println("--------------------------------------------");
        print(studentList);

        // output:
        /*
            Student{name='null', grade=70}
            Student{name='David', grade=66}
            Student{name='David', grade=63}
            Student{name='Ceb', grade=70}
            Student{name='Bob', grade=92}
            Student{name='Benjamin', grade=90}
            Student{name='Alice', grade=88}
         */
    }

    public void compoundOrdering() {
        System.out.println("====================order:compound===============");
        List<PureStudent> pureStudents = generateStudent();
        Ordering<PureStudent> ordering = Ordering.natural().onResultOf(sortFunction).compound(gradeComparator);
        pureStudents.sort(ordering);
        print(pureStudents);

        // output:
        /*
            Student{name='Alice', grade=88}
            Student{name='Benjamin', grade=90}
            Student{name='Bob', grade=92}
            Student{name='Ceb', grade=70}
            Student{name='David', grade=63}
            Student{name='David', grade=66}
         */
    }

    public void greatestOf() {
        System.out.println("====================order:greatestOf===============");
        List<PureStudent> pureStudents = generateStudent();
        List<PureStudent> topList = Ordering.natural().onResultOf(sortFunction).greatestOf(pureStudents.iterator(), 2);
        print(topList);

        //output:
        /*
            Student{name='David', grade=66}
            Student{name='David', grade=63}
         */
    }

    public static void main(String[] args) {

        GuavaOrder guavaOrder = new GuavaOrder();

        guavaOrder.defaultOrdering();
        guavaOrder.naturalOrdering();
        guavaOrder.usingToStringOrdering();
        guavaOrder.allEqualOrdering();
        guavaOrder.arbitraryOrdering();
        guavaOrder.fromOrdering();
        guavaOrder.explicitOrdering();
        guavaOrder.chainOrdering();
        guavaOrder.compoundOrdering();
        guavaOrder.greatestOf();


    }
}
