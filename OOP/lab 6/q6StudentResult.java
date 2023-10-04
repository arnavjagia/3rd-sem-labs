/*
WRONG Question can not derive from 2 classes
Design a base class called Student with the following 2 fields:- (i) Name (ii) Id. Derive 2 classes called Sports and Exam from the Student base class. Class Sports has a field called s_grade and class Exam has a field called e_grade which are integer fields. Derive a class called Results which inherit from Sports and Exam. This class has a character array or string field to represent the final result. Also it has a method called display which can be used to display the final result. Illustrate the usage of these classes in main.
*/

class Student {
    String name; 
    int id;
    
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Sports extends Student {
    int s_grade;
    
    Sports(String name, int id, int s_grade) {
        super(name, id);
        this.s_grade = s_grade;
    }
    void display() {
        System.out.printf("\nStudent name: %s\nStudent ID: %d\nSports Grade: %d\n",
                name, id, s_grade);
    }
}

class Exam extends Student {
    int e_grade;
    
    Exam(String name, int id, int e_grade) {
        super(name, id);
        this.e_grade = e_grade;
    }
    void display() {
        System.out.printf("\nStudent name: %s\nStudent ID: %d\nExam Grade: %d\n",
                name, id, e_grade);
    }
}

class Results extends Student {
    int s_grade;
    int e_grade;
    String res;

    Results(String name, int id, int s_grade, int e_grade) {
        super(name, id);
        this.s_grade = s_grade;
        this.e_grade = e_grade;

        finalRes();
    }

    void finalRes() {
        if (s_grade >= 70 && e_grade >= 60) {
            res = "Pass";
        } else {
            res = "Fail";
        }
    }

    void display() {
        System.out.printf("\nStudent name: %s\nStudent ID: %d\nSports Grade: %d\nExam Grade: %d\nFinal Result: %s\n",
                name, id, s_grade, e_grade, res);
    }
}

class q6StudentResult {
    public static void main(String[] args) {
        // Create a Sports object
        Sports sportsStudent = new Sports("John", 101, 75);

        // Create an Exam object
        Exam examStudent = new Exam("Alice", 102, 80);

        // Create a Results object which inherits from both Sports and Exam
        Results resultsStudent = new Results("Bob", 103, 65, 70);

        // Display the information and final result for each student
        System.out.println("Sports Student:");
        sportsStudent.display();
        System.out.println();

        System.out.println("Exam Student:");
        examStudent.display();
        System.out.println();

        System.out.println("Results Student:");
        resultsStudent.display();
    }
}

/* ------------------------------- SAMPLE --------------------------------
Sports Student:
Student Name: John
Student ID: 101
Sports Grade: 75
Exam Grade: 0
Final Result: Fail

Exam Student:
Student Name: Alice
Student ID: 102
Sports Grade: 0
Exam Grade: 80
Final Result: Fail

Results Student:
Student Name: Bob
Student ID: 103
Sports Grade: 65
Exam Grade: 70
Final Result: Pass
*/