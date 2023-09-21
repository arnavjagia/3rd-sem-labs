/*
Add member functions to the above code that perform the following operations

a) List all the students whose name starts with a particular character.
b) List all the student names containing a particular sub string.
c) Change the full name in the object to name with just initials and family name. For example, Prakash alingrao Aithal must be changed to P. K. Aithal and store it in the object. Display modified objects.
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

    // Getter for semester
    short getSemester() {
        return sem;
    }

    // Getter for CGPA
    float getCGPA() {
        return cgpa;
    }


    // Getter for name
    String getName() {
        return name;
    }

    // Function to list students whose name starts with a particular character
    static void listStudentsWithStartingCharacter(enStudent[] students, char startChar) {
        System.out.println("Students whose name starts with '" + startChar + "':");
        for (enStudent student : students) {
            if (student.getName().charAt(0) == startChar) {
                student.display();
            }
        }
    }

    // Function to list students whose name contains a particular substring
    static void listStudentsWithSubstring(enStudent[] students, String subString) {
        System.out.println("Students whose name contains '" + subString + "':");
        for (enStudent student : students) {
            if (student.getName().contains(subString)) {
                student.display();
            }
        }
    }

    // Function to change the full name to initials and family name
    void changeNameToInitials() {
        String[] nameParts = name.split(" ");
        if (nameParts.length >= 2) {
            StringBuilder modifiedName = new StringBuilder();
            for (int i = 0; i < nameParts.length - 1; i++) {
                modifiedName.append(nameParts[i].charAt(0)).append(". ");
            }
            modifiedName.append(nameParts[nameParts.length - 1]);
            name = modifiedName.toString();
        }
    }

    // ... (previous code)
}

public class q5OpsEnhancedStudent {
    public static void main(String[] args) {
        // Scanner Object creation
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of students- ");
        int n = sc.nextInt();
        enStudent[] std = new enStudent[n];

        // Read student information
        for (int i = 0; i < std.length; i++) {
            std[i] = enStudent.read(sc, i);
        }

        // Display all students
        System.out.println("\nStudent Records:");
        for (int i = 0; i < std.length; i++) {
            std[i].display();
        }

        // List students whose name starts with a particular character
        System.out.print("\nEnter a character to list students whose name starts with: ");
        char startChar = sc.next().charAt(0);
        enStudent.listStudentsWithStartingCharacter(std, startChar);

        // List students whose name contains a particular substring
        sc.nextLine(); // Consume the newline character
        System.out.print("\nEnter a substring to list students whose name contains: ");
        String subString = sc.nextLine();
        enStudent.listStudentsWithSubstring(std, subString);

        // Change the full name to initials and family name and display modified objects
        for (enStudent student : std) {
            student.changeNameToInitials();
        }

        System.out.println("\nModified Student Records:");
        for (enStudent student : std) {
            student.display();
        }
    }
}
}
