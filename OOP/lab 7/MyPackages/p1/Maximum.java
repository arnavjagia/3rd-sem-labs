/*
Define a class Maximum with the following overloaded static methods

max (which finds maximum among three integers and returns the maximum integer) 
max (which finds maximum among three floating point numbers and returns the maximum among them) 
max (which finds the maximum in an array and returns it) 
max (which finds the maximum in a matrix and returns the result)
Place this in a package called myPackages.p1. Write a main method to use the methods of Maximum class in package p1.
*/

package MyPackages.p1;

public class Maximum {
    public static int max(int a, int b, int c) { return (int) max((double)a,(double)b,(double)c); }
    public static double max(double a, double b, double c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        }
        else {
            if (b > c) return b;
            else return c;
        }
    }
    public static int max(int[] a) {
        int max = a[0];
        for (int x : a) {
            if (x > max) max = x;
        }
        return max;
    }
    public static int max(int[][] a) {
        int max = a[0][0];
        for (int x[] : a) {
            if (max(x) > max) max = max(x);
        }
        return max;
    }
}