/*
Person class with private instance variables for the person’s name and birth date. Add appropriate accessor methods for these variables. Then create a subclass College Graduate with private instance variables for the student’s GPA and year of graduation and appropriate accessors for these variables. Include appropriate constructors for your classes. Then create a class with main() method that demonstrates your classes.
*/

class Person {
    private String name, dob;

    Person() { name = dob = "''"; }

    String getName() { return name; }
    void setName(String name) { this.name = name; }

    String getDob() { return dob; }
    void setDob(String dob) { this.dob = dob; }
}

class CollegeGrad extends Person{
    private int gpa, yog;

    CollegeGrad() { gpa = yog = 0; }

    int getGPA() { return gpa; }
    void setGPA(int gpa) { this.gpa = gpa; }
    
    int getYOG() { return yog; }
    void setYOG(int yog) { this.yog = yog; }
}

public class q3Person {
    public static void main(String[] args) {
        CollegeGrad std = new CollegeGrad();
        std.setName("Test");
        std.setDob("01/01/2023");
        std.setGPA(9);
        std.setYOG(2023);
        System.out.println(std.getName() + "\n"
            + std.getDob() + "\n"
            + std.getYOG() + "\n"
            + std.getGPA() + "\n");
    }
}

/*----------------------SAMPLE-------------------
Test
01/01/2023
2023
9
*/