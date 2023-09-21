/*
Perform the following operations by adding member functions to the program implemented in the above question

a) Sort the student records with respect to semester and CGPA.
b) Sort the student record with respect to name.
*/
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

class enStudent {
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

    enStudent(String r, String n, GregorianCalendar d, short s, float g, float c) {
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

    static enStudent read(Scanner sc, int i) {
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

        String r = enStudent.setRegistration(year, i);

        return new enStudent(r, n, d, s, g, cg);
    }

    // Sort by semester and CGPA using Bubble Sort
    static void sortBySemesterAndCGPA(enStudent[] students) {
        int n = students.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (students[i].getSemester() > students[i + 1].getSemester() ||
                        (students[i].getSemester() == students[i + 1].getSemester() &&
                                students[i].getCGPA() < students[i + 1].getCGPA())) {
                    // Swap students[i] and students[i+1]
                    enStudent temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Sort by name using Bubble Sort
    static void sortByName(enStudent[] students) {
        int n = students.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (students[i].getName().compareTo(students[i + 1].getName()) > 0) {
                    // Swap students[i] and students[i+1]
                    enStudent temp = students[i];
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
        enStudent[] std = new enStudent[n];
        for (int i = 0; i < std.length; i++) {
            std[i] = enStudent.read(sc, i);
        }

        // Sorting options
        System.out.println("\nChoose sorting option:");
        System.out.println("1. Sort by semester and CGPA");
        System.out.println("2. Sort by name");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                enStudent.sortBySemesterAndCGPA(std);
                break;
            case 2:
                enStudent.sortByName(std);
                break;
            default:
                System.out.println("Invalid choice. Sorting by semester and CGPA by default.");
                enStudent.sortBySemesterAndCGPA(std);
                break;
        }

        System.out.println("\nSorted Student Records:");
        for (int i = 0; i < std.length; i++) {
            std[i].display();
        }
    }
}
