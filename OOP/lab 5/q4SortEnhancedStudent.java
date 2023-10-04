/*
Perform the following operations by adding member functions to the program implemented in the above question

a) Sort the student records with respect to semester and CGPA.
b) Sort the student record with respect to name.
*/
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

class sortStudent {
    // ... (previous code)
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

    sortStudent(String r, String n, GregorianCalendar d, short s, float g, float c) {
        reg = r;
        name = n;
        doj = d;
        sem = s;
        gpa = g;
        cgpa = c;
    }

    void display() {
        System.out.printf("\nRegistration no: %s\nName: %s\ndoj: %d/%d/%d\nsem: %d\ngpa: %f\ncgpa: %f\n",
                reg, name, doj.get(Calendar.DATE), doj.get(Calendar.MONTH) + 1, doj.get(Calendar.YEAR), sem, gpa, cgpa);
    }

    static sortStudent read(Scanner sc, int i) {
        sc.nextLine(); // Consume the newline character left by previous nextInt()

        System.out.println("Input for student " + (i + 1) + ":");
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

        String r = sortStudent.setRegistration(year, i);

        return new sortStudent(r, n, d, s, g, cg);
    }

    // Sort by semester and CGPA using Bubble Sort
    static void sortBySemesterAndCGPA(sortStudent[] students) {
        int n = students.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (students[i].getSemester() > students[i + 1].getSemester() ||
                        (students[i].getSemester() == students[i + 1].getSemester() &&
                                students[i].getCGPA() < students[i + 1].getCGPA())) {
                    // Swap students[i] and students[i+1]
                    sortStudent temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Sort by name using Bubble Sort
    static void sortByName(sortStudent[] students) {
        int n = students.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (students[i].getName().compareTo(students[i + 1].getName()) > 0) {
                    // Swap students[i] and students[i+1]
                    sortStudent temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    // Getter for name
    String getName() {
        return name;
    }

    // Getter for semester
    short getSemester() {
        return sem;
    }

    // Getter for CGPA
    float getCGPA() {
        return cgpa;
    }
    // ... (previous code)
}

public class q4SortEnhancedStudent {
    public static void main(String[] args) {
        // Scanner Object creation
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students- ");
        int n = sc.nextInt();
        sortStudent[] std = new sortStudent[n];
        for (int i = 0; i < std.length; i++) {
            std[i] = sortStudent.read(sc, i);
        }

        // Sorting options
        System.out.println("\nChoose sorting option:");
        System.out.println("1. Sort by semester and CGPA");
        System.out.println("2. Sort by name");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sortStudent.sortBySemesterAndCGPA(std);
                break;
            case 2:
                sortStudent.sortByName(std);
                break;
            default:
                System.out.println("Invalid choice!!");
        }

        System.out.println("\nSorted Student Records:");
        for (int i = 0; i < std.length; i++) {
            std[i].display();
        }
    }
}

/*
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

Choose sorting option:
1. Sort by semester and CGPA
2. Sort by name
1

Sorted Student Records:

Registration no: 2202
Name: b
doj: 1/2/2022
sem: 3
gpa: 9.200000
cgpa: 9.200000

Registration no: 2301
Name: a
doj: 10/11/2023
sem: 3
gpa: 8.800000
cgpa: 8.800000
*/