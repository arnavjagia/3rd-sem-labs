/*
Add the following string processing methods to the class Employee:

a) formatEmployeeName(): A method that formats the employee's name by capitalizing the first letter of each word and converting the remaining letters to lowercase. For example, if the employee's name is "JOHN DOE", this method would transform it to "John Doe".
b) generateEmail(): A method that generates an email address for the employee based on their name. For example, if the employee's name is "John Doe", this method would generate an email address like "jdoe@example.com".
*/
import java.util.*;

class Employee {
    String Ename;
    int Eid;
    double Basic;

    Employee() {
        Ename = "NULL";
        Eid = 0;
        Basic = 0.0;
    }

    Employee(String name, int eid, double bas) {
        Ename = name;
        Eid = eid;
        Basic = bas;
    }

    void formatEmployeeName()
    {
        String nName="";
        int len = Ename.length();

        char firstChar = Ename.charAt(0);
        nName += (!isWhitespace(firstChar) && !isCaps(firstChar)) ? firstChar : firstChar - 32;
        for(int i = 1; i < len; i++)
        {
            char ele = Ename.charAt(i);
            nName += (!isWhitespace(ele) && isCaps(ele)) ? ele : ele - 32;
        }
        Ename = nName;
    }
    private boolean isCaps(char c) {return c>=65 && c<=90;}
    private boolean isWhitespace(char c) {return c == 32;}

    String generateEmail()
    {
        String email = "";
        return email;
    }

    void display() {
        System.out.println("Employee Name- " + Ename);
        System.out.println("Employee ID- " + Eid);
        System.out.println("Basic Salary- " + Basic);
    }
}

public class q1EmployeeStrings {
    public static void main(String[] args) {
        Employee emp = new Employee("JOHN DOE", 12, 100.01);
        emp.display();
        emp.formatEmployeeName();
        emp.display();
    }
}
