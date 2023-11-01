/*
Define a simple generic stack class and show the use of the generic class for two different class types Student and Employee class objects.
*/

import java.util.*;

class Stack <T> {
    T[] stk; int top;
    Stack() {
        stk = (T[]) new Object[10];
        top = -1;
    }

    void push(T ele) {
        if (top >= 10) {System.out.println("Stack overflow"); return;}
        stk[++top] = ele;
    }

    T pop() {
        if (top == -1) {System.out.println("Stack underflow"); return null;}
        return stk[top--];
    }

    void display() {
        if (top == -1) {System.out.println("Stack is empty"); return;}
        System.out.println("---Displaying stack---");
        for (int i = top; i >=0; i--) {
            System.out.print(stk[i] + " ");
        }
        System.out.println("\nTop: " + top + "\n");
    }
}

class q2Stack{
    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.display();
        stk.pop();
        stk.pop();
        stk.display();
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Note: q2Stack.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
---Displaying stack---
4 3 2 1 
Top: 3

---Displaying stack---
2 1 
Top: 1

*/