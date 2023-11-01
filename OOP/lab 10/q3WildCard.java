/*
Write a program to demonstrate the use of wildcard arguments for question no. 2.
*/

import java.util.*;

class Stack <T> {
    Object[] stk; int top;
    Stack() {
        stk = new Object[10];
        top = -1;
    }

    void push(Stack<?> s, Object ele) {
        if (top >= 10) {System.out.println("Stack overflow"); return;}
        stk[++top] = ele;
    }

    Object pop(Stack<?> s) {
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

class q3WildCard {
    public static void main(String[] args) {
        Stack<Integer> i = new Stack<>();
        Stack<Character> c = new Stack<>();

        i.push(i, 1);
        i.push(i, 2);
        c.push(c, 'a');
        c.push(c, 'b');

        i.display();
        c.display();
    }
}

/* ------------------------------- SAMPLE --------------------------------
---Displaying stack---
2 1 
Top: 1

---Displaying stack---
b a 
Top: 1

*/