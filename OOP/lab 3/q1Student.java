/*
Define a Class STUDENT having following Members: sname, marks_array, and provide the following methods:

    assign(): to assign initial values to the STUDENT object
    display(): to display the STUDENT object
    compute(): to Compute Total, Average marks

Write a Java program Illustrating Class Declarations, Definition, and Accessing Class Members to test the class defined.
*/

import java.util.*;

class Student {
    String sname;
    int[] marks_array;

    // call to assign values to the STUDENT object
    void assign() {
        // reading student name
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        sname = sc.nextLine();
        // reading marks array
        System.out.print("#marks: ");
        int n = sc.nextInt();
        marks_array = new int[n];
        System.out.println("Enter marks");
        for (int i = 0; i < n; i++)
            marks_array[i] = sc.nextInt();
    }

    // displays STUDENT object
    void display() {
        // displaying name
        System.out.println("Name- " + sname);
        // displaying marks array
        System.out.print("Marks- ");
        for (int mark : marks_array)
            System.out.print(mark + " ");
        System.out.println();
    }

    // displays total and average marks
    void compute() {
        // total computation
        int total = 0;
        for (int mark : marks_array)
            total += mark;
        // avg computation
        double avg = (double) total / marks_array.length;
        // display
        System.out.println("Total Marks- " + total);
        System.out.println("Avg Marks- " + avg);
    }
}

class q1Stud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("#students: ");
        int n = sc.nextInt();

        Student[] stu = new Student[n];

        for (int i = 0; i < n; i++) {
            stu[i] = new Student();
            stu[i].assign();
            System.out.println();
        }

        System.out.println();
        for (Student s : stu) {
            s.display();
            s.compute();
            System.out.println();
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------   
#students: 2
Name: a
#marks: 3
Enter marks
4 6 9

Name: b
#marks: 3
Enter marks
2 8 10


Name- a
Marks- 4 6 9 
Total Marks- 19
Avg Marks- 6.333333333333333

Name- b
Marks- 2 8 10 
Total Marks- 20
Avg Marks- 6.666666666666667
*/