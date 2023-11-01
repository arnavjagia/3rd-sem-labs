/*
Write a generic method to exchange the positions of two different elements in an array.
*/

import java.util.*;

class Swapper {
    static <T> T[] swap (T[] a, int i1, int i2) {
        T temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
        return a;
    }
}

class q1ExchangeElements {
    public static void main(String[] args) {
        // testing for String

        String a[] = {"Hello", "World"};
    
        System.out.print("Original array: ");
        for (String x : a) System.out.print(x+ " ");
	    System.out.println();

        a = Swapper.swap(a, 0, 1);

        System.out.print("Swapped array: ");
        for (String x : a) System.out.print(x+ " ");
	    System.out.println();
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Original array: Hello World
Swapped array: World Hello
*/