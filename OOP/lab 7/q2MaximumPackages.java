/*
Define a class Maximum with the following overloaded static methods

max (which finds maximum among three integers and returns the maximum integer) 
max (which finds maximum among three floating point numbers and returns the maximum among them) 
max (which finds the maximum in an array and returns it) 
max (which finds the maximum in a matrix and returns the result)
Place this in a package called myPackages.p1. Write a main method to use the methods of Maximum class in package p1.
*/

import MyPackages.p1.*;

public class q2MaximumPackages {
    public static void main(String[] s) {
        int res = Maximum.max(new int[][] { { 0, 1 }, { 2, 3 } });
        System.out.println(res);
        res = Maximum.max(9,7,3);
        System.out.println(res);
        double r = Maximum.max(4.9, 9.6, 1.9);
        System.out.println(r);
    }
    
}
