/*
Design a Student class with appropriate data members as in Lab 5. Provide your own exceptions namely Seats Filled Exception, which is thrown when Student registration number is >XX25 (where XX is last two digits of the year of joining) Show the usage of this exception handling using Student objects in the main. (Note: Registration number must be a unique number)
*/

import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

class SeatsFilledException extends Exception {
    public String toString() {return "SeatsFilledException: Seats are filled.";}
}

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

class q3StudentException{
    public static void main(String[] args) {
        // Scanner Object creation
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students- ");
        int n = sc.nextInt();
        enStudent[] std = new enStudent[n];
        try{
            for (int i = 0; i < std.length; i++) {
                std[i] = enStudent.read(sc, i);
                int regnoLast2Digits = 10 * (std[i].reg.charAt(2) - 48) + (std[i].reg.charAt(3) - 48);
                if (regnoLast2Digits > 25)
                    throw new SeatsFilledException();
            }
        } catch(SeatsFilledException e){
            System.out.println(e);
        }
        for (int i = 0; i < std.length; i++) {
            std[i].display();
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Number of students- 1
Input for student 1:
Name: a
DOJ (Year Month Day): 2023 11 10
Semester: 3
GPA: 8.8
CGPA: 8.8

Registration no: 2301
Name: a
doj: 10/11/2023
sem: 3
gpa: 8.800000
cgpa: 8.800000
*/