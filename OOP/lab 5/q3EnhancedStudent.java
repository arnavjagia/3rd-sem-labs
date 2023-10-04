/*
Design a class which represents a student. Every student record is made up of the following fields.

a. Registration number (int)
b. Full Name (String)
c. Date of joining (Gregorian calendar)
d. Semester (short)
e. GPA (float)
f. CGPA (float)

Whenever a student joins he will be given a new registration number. Registration number is calculated as follows. If year of joining is 2012 and he is the 80th student to join then his registration number will be 1280.

Write member functions to do the following.

a) Provide parameterized constructors to this class
b) Write display method which displays the record. Test the class by writing suitable main method.
c) Create an array of student record to store minimum of 5 records in it. Input the records and display them.
*/
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

class enStudent {
    String reg, name;
    static GregorianCalendar doj;
    short sem;
    float gpa, cgpa;

    static String setRegistration(int year, int i) {
        String reg = "";
        int yearLastTwoDigits = year % 100;
        int studentIndex = i + 1; // Increment i by 1 since indexing typically starts from 1, not 0

        if (yearLastTwoDigits < 10) {
            reg += "0"; // Add a leading zero for years < 10
        }

        reg += yearLastTwoDigits;

        if (studentIndex < 10) {
            reg += "0"; // Add a leading zero for student indices < 10
        }

        reg += studentIndex;

        return reg;
    }

    enStudent(String r, String n, GregorianCalendar d, short s, float g, float c)
    {
        reg = r; name = n; doj = d; sem = s; gpa = g; cgpa = c;
    }

    void display() {
        System.out.printf("\nRegistration no: %s\nName: %s\ndoj: %d/%d/%d\nsem: %d\ngpa: %f\ncgpa: %f\n",
        reg, name, doj.get(Calendar.DATE), doj.get(Calendar.MONTH)+1, doj.get(Calendar.YEAR), sem, gpa, cgpa);
    }
    
    static enStudent read(Scanner sc, int i) {
        sc.nextLine(); // Consume the newline character left by previous nextInt()

        System.out.println("Input for student " + (i+1) + ":");
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("DOJ (Year Month Day): ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        System.out.print("Semester: ");
        short s = sc.nextShort();

        System.out.print("GPA: ");
        float g = sc.nextFloat();

        System.out.print("CGPA: ");
        float cg = sc.nextFloat();

        
        // Create a GregorianCalendar with the provided date
        GregorianCalendar d = new GregorianCalendar(year, month - 1, day); // Month is 0-based

        String r = enStudent.setRegistration(year, i);
        
        return new enStudent(r, n, d, s, g, cg);
    }
}

public class q3EnhancedStudent {
    public static void main(String[] args) {
        // Scanner Object creation
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students- ");
        int n = sc.nextInt();
        enStudent[] std = new enStudent[n];
        for (int i = 0; i < std.length; i++) {
            std[i] = enStudent.read(sc, i);
        }
        System.out.println();
        for (int i = 0; i < std.length; i++) {
            std[i].display();
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------
Number of students- 2
Input for student 1:
Name: a    
DOJ (Year Month Day): 2023 11 10
Semester: 3
GPA: 8.8
CGPA: 8.8
Input for student 2:
Name: b
DOJ (Year Month Day): 2022 02 01
Semester: 3
GPA: 9.2
CGPA: 9.2


Registration no: 2301
Name: a
doj: 1/2/2022
sem: 3
gpa: 8.800000
cgpa: 8.800000

Registration no: 2202
Name: b
doj: 1/2/2022
sem: 3
gpa: 9.200000
cgpa: 9.200000
*/