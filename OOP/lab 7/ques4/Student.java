package ques4;
/*
Design a class Student with the methods, get Number and put Number to read and display the Roll No. of each student and get Marks() and put Marks() to read and display their marks. Create an interface called Sports with a method put Grade() that will display the grade obtained by a student in Sports. Design a class called Result that will implement the method put Grade() and generate the final result based on the grade in sports and the marks obtained from the superclass Student.
*/

import java.util.*;

public class Student {
    int rno, marks[];

    void getNumber(int rno) {
        this.rno = rno;
    }

    void putNumber() {
        System.out.println("Roll no: "+rno);
    }

    void getMarks() {
        Scanner sc = new Scanner(System.in);

        System.out.print("#marks: ");
        int[] m = new int[sc.nextInt()];
        System.out.print("Marks: ");
        for (int i = 0; i < m.length; i++)
            m[i] = sc.nextInt();
        
        marks = m;
    }

    void putMarks() {
        System.out.println("Marks: "+ Arrays.toString(marks));
    }
}