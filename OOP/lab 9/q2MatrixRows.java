/*
Write and execute a java program to create and initialize a matrix of integers. Create n threads( by implementing Runnable interface) where n is equal to the number of rows in the matrix. Each of these threads should compute a distinct row sum. The main thread computes the complete sum by looking into the partial sums given by  the threads.
*/

import java.util.*;

class MyThread implements Runnable {
    Thread thrd;
    int[] row;
    int sum;

    MyThread(int[] r) {
        thrd = new Thread(this);
        row = r;
        thrd.start();
    }

    public void run() {
        sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
    }

    public int getSum() {
        return sum;
    }
}

class q2MatrixRows {
    public static void main(String[] args) {
        // def scanning object
        Scanner sc = new Scanner(System.in);

        // reading size and declaring matrix 
        System.out.print("Rows and columns: ");
        int numRows = sc.nextInt();
        int numCols = sc.nextInt();
        int[][] matrix = new int[numRows][numCols];
    
        // reading elements of matrices
        System.out.println("Enter matrix: ");
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                matrix[i][j] = sc.nextInt();

        MyThread[] threads = new MyThread[numRows];

        // create and start threads
        for (int i = 0; i < numRows; i++) {
            threads[i] = new MyThread(matrix[i]);
            new Thread(threads[i]).start();
        }

        // wait for threads to finish
        for (int i = 0; i < numRows; i++) {
            try {
                threads[i].thrd.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted..");
            }
        }

        // compute complete sum
        int completeSum = 0;
        for (int i = 0; i < numRows; i++) {
            completeSum += threads[i].getSum();
        }
        System.out.println("Complete sum: " + completeSum);
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Rows and columns: 3 3
Enter matrix: 
1 2 3
4 5 6
7 8 9
Complete sum: 45
*/