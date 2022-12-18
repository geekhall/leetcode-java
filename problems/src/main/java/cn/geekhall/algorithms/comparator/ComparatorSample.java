package cn.geekhall.algorithms.comparator;

import cn.geekhall.bean.Student;

import java.util.Arrays;

/**
 * ComparatorSample.java
 *
 * @author yiny
 */
public class ComparatorSample {

    public static void main(String[] args) {
        Student student1 = new Student("001", "Eric", 15);
        Student student2 = new Student("002", "King", 13);
        Student student3 = new Student("003", "Tony", 16);
        Student student4 = new Student("004", "Gin",  18);
        Student[] students = new Student[] {student1, student2, student3, student4};
        printStudents(students);
        Arrays.sort(students, new IdDescComparator());
        printStudents(students);
        Arrays.sort(students, new IdAscComparator());
        printStudents(students);
    }

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
