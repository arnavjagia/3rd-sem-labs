/*
Add the following string processing methods to the class STUDENT:

a) extractInitials(): A method that extracts the initials from the student's name. For example, if the student's name is "John Doe", this method would return "JD".
b) removeWhitespace(): A method that removes any whitespace characters from the student's name. For example, if the student's name is "John Doe", this method would transform it to "JohnDoe".
c) List all the student names containing a particular sub string.
d) Sort the students alphabetically
*/

import java.util.Scanner;

class StudentStr {
    String sname;
    int[] marks_array;

    // call to assign values to the STUDENT object
    void assign() {
        // reading student name
        try (Scanner sc = new Scanner(System.in);) {
            System.out.print("Name: ");
            sname = sc.nextLine();
            // reading marks array
            System.out.print("#marks: ");
            int n = sc.nextInt();
            marks_array = new int[n];
            System.out.println("Enter marks");
            for (int i = 0; i < n; i++)
                marks_array[i] = sc.nextInt();
        }
    }

    // displays STUDENT object
    void display() {
        // displaying name
        System.out.println("Name- " + sname);
        // displaying marks array
        System.out.print("Marks- ");
        for (int mark : marks_array)
            System.out.print(mark + " ");
        System.out.println();
    }

    // displays total and average marks
    void compute() {
        // total computation
        int total = 0;
        for (int mark : marks_array)
            total += mark;
        // avg computation
        double avg = (double) total / marks_array.length;
        // display
        System.out.println("Total Marks- " + total);
        System.out.println("Avg Marks- " + avg);
    }

    String extractInitials() {
        String initials = "" + sname.charAt(0);
        // searching for whitespace
        for (int i = 0; i < sname.length(); i++) {
            if (sname.charAt(i) == ' ') initials += sname.charAt(i+1);
        }
        return initials;
    }

    void removeWhitespace() {
        // creating a new string 'nString'
        String nString = "";
        // finding whitespace
        for (int i = 0; i < sname.length(); i++) {
            if (sname.charAt(i) == ' ') continue;
            nString += sname.charAt(i);
        }
        // assigning nString back to sname
        sname = nString;
    }
}

public class q2StudentStrings {
    public static void main(String[] args) {
        StudentStr std = new StudentStr();
        std.assign();
        System.out.println(std.extractInitials());
        std.removeWhitespace();
        System.out.println(std.sname);
    }
}

/* ------------------------------- SAMPLE --------------------------------
Name:

Arnav Jagia#marks:2
Enter marks 2 4
AJ
ArnavJagia
*/