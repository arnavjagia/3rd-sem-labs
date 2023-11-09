/*
Define a simple generic stack class and show the use of the generic class for two different class types Student and Employee class objects.
*/

import java.util.*;

class Stack<T> {
    T[] stk;
    int top;

    Stack() {
        stk = (T[]) new Object[10];
        top = -1;
    }

    void push(T ele) {
        if (top >= 10) {
            System.out.println("Stack overflow");
            return;
        }
        stk[++top] = ele;
    }

    T pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return null;
        }
        return stk[top--];
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("---Displaying stack---");
        for (int i = top; i >= 0; i--) {
            System.out.print(stk[i]);
        }
        System.out.println("\nTop: " + top + "\n");
    }
}

class Student {
    String name;
    int rollno;

    Student(String n, int r) {
        name = n;
        rollno = r;
    }
    
    public String toString() {
        return name + " " + rollno + "\n";
    }
}

class Employee {
    String name;
    int id;

    Employee(String n, int i) {
        name = n;
        id = i;
    }

    public String toString() {
        return name + " " + id + "\n";
    }
}

class q2Stack{
    public static void main(String[] args) {
        Stack<Student> stkStud = new Stack<>();
        Stack<Employee> stkEmp = new Stack<>();

        stkStud.push(new Student("Rahul", 1));
        stkStud.push(new Student("Raj", 2));
        stkStud.display();
        
        stkStud.pop();
        stkStud.display();
        
        stkEmp.push(new Employee("Rohan", 101));
        stkEmp.push(new Employee("Ramesh", 102));
        stkEmp.display();
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Note: q2Stack.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
---Displaying stack---
Raj 2
 Rahul 1

Top: 1

---Displaying stack---
Rahul 1

Top: 0

---Displaying stack---
Ramesh 102
 Rohan 101

Top: 1
*/