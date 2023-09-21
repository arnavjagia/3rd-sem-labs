/*
Write and execute a Java program to convert strings containing numbers into comma-punctuated numbers, with a comma every third digit from the right.
e.g., Input String : “1234567” Output String : “1,234,567”
*/
import java.util.*;

public class q6CommaPunctutatedNumbers {
    public static void main(String[] args)
    {
        String str, nString = "", rev = "";
        System.out.print("#: ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        
        int len = str.length();
        for (int i = len-1; i >= 0; i--) {
            int e = len-i-1;
            if (e != 0 && e % 3 == 0) nString += ',';
            nString += str.charAt(i);
        }

        for (int i = nString.length()-1; i >= 0; i--) {
            rev += nString.charAt(i);
        }
        System.out.println("Comma punctuated string: " + rev);
    }
}

/* ------------------------------- SAMPLE --------------------------------
#:1234567890

Comma punctuated string:1,234,567,890
*/