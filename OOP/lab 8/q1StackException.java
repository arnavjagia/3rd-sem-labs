/*
Design a stack class. Provide your own stack exceptions namely Push Exception and Pop Exception, which throw exceptions when the stack is full and when the stack is empty respectively. Show the usage of these exceptions in handling a stack object in the main.
*/
import java.util.*;

class PushException extends Exception {
    int ele;

    PushException(int ele) { this.ele = ele; }

    public String toString() {
        return "Stack is full Can't push " + ele;
    }
}

class PopException extends Exception {
    public String toString() { return "Stack is empty"; }
}

class Stack {
    int[] arr;
    int top;

    Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    void push(int ele) throws PushException {
        if (top == arr.length - 1) throw new PushException(ele);
        arr[++top] = ele;
    }

    int pop() throws PopException {
        if (top == -1)
            throw new PopException();
        return arr[top--];
    }
    
    void display() {
        System.out.print("\nStack: ");
        for (int i = 0; i <= top; i++) System.out.print(arr[i] + " ");
        System.out.println("\nTop: " + top + "\n");
    }
}

class q1StackException{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        Stack s = new Stack(sc.nextInt());
        System.out.print("1. Push\n2. Pop\n3. Display\n4. Exit");
        while (true) {
            System.out.print("\nEnter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    try {
                        s.push(ele);
                    } catch (PushException e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Popped element: " + s.pop());
                    } catch (PopException e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------   

*/