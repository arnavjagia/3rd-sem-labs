/*
To the already defined STUDENT class, add two subclasses ScienceStudent and ArtsStudent. Add a private data member practicalMarks (int): to the ScienceStudent class to represent the marks obtained by the student in the practical subject. The ScienceStudent class should override the compute() method to include the practical marks in the total marks and average marks calculation. The ScienceStudent class should provide a method displayPracticalMarks() to display the practical marks obtained by the science student. Add the private data member electiveSubject (String): to the ArtsStudent class to represent the elective subject chosen by the arts student. Also add appropriate constructors to the subclasses. In the Main class, create objects of STUDENT, ScienceStudent, and ArtsStudent, and demonstrate the keyword ‘super’ and other functionalities of the classes by assigning values, computing marks, and displaying the information of the students. Also demonstrate dynamic polymorphism.
*/
class Student {
    String sname;
    int[] marks_array;

    Student() {
        this.sname = "NULL";
        this.marks_array = new int[3];
    }

    Student(String name, int[] marks) {
        this.sname = name;
        this.marks_array = marks;
    }

    void display() {
        System.out.println("\nName- " + this.sname);
        System.out.print("Marks- ");
        for (int mark : this.marks_array)
            System.out.print(mark + " ");
        System.out.println();
    }

    void compute() {
        int total = 0;
        for (int mark : marks_array)
            total += mark;

        double avg = (double) total / marks_array.length;
        System.out.println("Total Marks- " + total);
        System.out.println("Avg Marks- " + avg);
    }
}

class ScienceStudent extends Student {
    private int practicalMarks;

    ScienceStudent() {
        super();
        this.practicalMarks = 0;
    }

    ScienceStudent(String name, int[] marks, int practicalMarks) {
        super(name, marks);
        this.practicalMarks = practicalMarks;
    }


    void compute() {
        super.compute();
        int total = 0;
        for (int mark : marks_array)
            total += mark;

        total += practicalMarks;

        double avg = (double) total / (marks_array.length + 1);
        System.out.println("Practical Marks- " + practicalMarks);
        System.out.println("Total Marks (including practical)- " + total);
        System.out.println("Avg Marks (including practical)- " + avg);
    }

    void displayPracticalMarks() {
        System.out.println("Practical Marks- " + practicalMarks);
    }
}

class ArtsStudent extends Student {
    private String electiveSubject;

    ArtsStudent() {
        super();
        this.electiveSubject = "NULL";
    }

    ArtsStudent(String name, int[] marks, String electiveSubject) {
        super(name, marks);
        this.electiveSubject = electiveSubject;
    }

    void displayElectiveSubject() {
        System.out.println("Elective Subject- " + electiveSubject);
    }
}

public class q1StudentInheritance {
    public static void main(String[] args) {
        int[] marks = { 90, 85, 95 };

        Student student = new Student("John", marks);
        student.display();
        student.compute();

        ScienceStudent scienceStudent = new ScienceStudent("Jane", marks, 80);
        scienceStudent.display();
        scienceStudent.displayPracticalMarks();
        scienceStudent.compute();
        
        ArtsStudent artsStudent = new ArtsStudent("Alice", marks, "History");
        artsStudent.display();
        artsStudent.displayElectiveSubject();
        artsStudent.compute();

        Student sci = new ScienceStudent("Jane", marks, 80);
        sci.display();
        // sci.displayPracticalMarks();
        sci.compute();
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Name- John
Marks- 90 85 95 
Total Marks- 270
Avg Marks- 90.0

Name- Jane
Marks- 90 85 95 
Practical Marks- 80
Total Marks- 270
Avg Marks- 90.0
Practical Marks- 80
Total Marks (including practical)- 350
Avg Marks (including practical)- 87.5

Name- Alice
Marks- 90 85 95 
Elective Subject- History
Total Marks- 270
Avg Marks- 90.0

Name- Jane
Marks- 90 85 95 
Total Marks- 270
Avg Marks- 90.0
Practical Marks- 80
Total Marks (including practical)- 350
Avg Marks (including practical)- 87.5
*/