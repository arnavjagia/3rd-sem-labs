/*
Create a class by extending Thread Class to print a multiplication table of a number supplied as parameter. Create another class Tables which will instantiate two objects of the above class to print multiplication table of 5 and 7.
*/

import java.util.*;

class MyThread extends Thread {
    int num;

    MyThread(int num) {
        this.num = num;
        start();
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}

class q1MultTable {
// class Tables {
    public static void main(String[] args) {
        try {
            MyThread table5 = new MyThread(5);
            table5.join();

            MyThread table7 = new MyThread(7);
            table7.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted..");
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------   

5 x 1 = 5
7 x 1 = 7
5 x 2 = 10
7 x 2 = 14
5 x 3 = 15
7 x 3 = 21
5 x 4 = 20
7 x 4 = 28
5 x 5 = 25
7 x 5 = 35
5 x 6 = 30
7 x 6 = 42
5 x 7 = 35
7 x 7 = 49
5 x 8 = 40
7 x 8 = 56
5 x 9 = 45
7 x 9 = 63
5 x 10 = 50
7 x 10 = 70

*/