/*
Add the following string processing methods to the class Employee:

a) formatEmployeeName(): A method that formats the employee's name by capitalizing the first letter of each word and converting the remaining letters to lowercase. For example, if the employee's name is "JOHN DOE", this method would transform it to "John Doe".
b) generateEmail(): A method that generates an email address for the employee based on their name. For example, if the employee's name is "John Doe", this method would generate an email address like "jdoe@example.com".
*/
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

    void formatEmployeeName() {
        String nName="";
        Ename = Ename.strip();
        int len = Ename.length();
        /*
        "  JOHN  DOE  "
        */
        char firstChar = Ename.charAt(0);
        nName += (isCaps(firstChar)) ? firstChar : (char) (firstChar - 32);
        for(int i = 1; i < len - 1; i++) {
            char present = Ename.charAt(i), next = Ename.charAt(i+1);
            if (isSpace(present)) {
                if (isSpace(next)) continue;
                nName += ' ';
                nName += (isCaps(next)) ? next : (char) (next - 32); i++;
            } else {
                nName += (isCaps(present)) ? (char) (present + 32) : present;
            }
        }
        char endChar = Ename.charAt(len-1);
        nName += (isCaps(endChar)) ? (char) (endChar + 32) : endChar;
        Ename = nName;
    }
    private boolean isCaps(char c) { return c>=65 && c<=90; }
    private boolean isSpace(char c) { return c == 32; }

    String generateEmail() {
        this.formatEmployeeName();
        String email = "";
        char firstChar = Ename.charAt(0);
        email += firstChar;
        boolean reachSpace = false;
        for (int i = 1; i < Ename.length(); i++) {
            char c = Ename.charAt(i);
            if (!reachSpace) {
                if (c == 32) reachSpace = true;
            } else { email += c; }
        }
        email += "@gmail.com";
        return email.toLowerCase();
    }

    void display() {
        System.out.println("Employee Name- " + Ename);
        System.out.println("Employee ID- " + Eid);
        System.out.println("Basic Salary- " + Basic);
    }
}

public class q1EmployeeStrings {
    public static void main(String[] args) {
        Employee emp = new Employee("   JOHN    DOE   ", 12, 100.01);
        emp.display();
        emp.formatEmployeeName();
        System.out.println();
        emp.display();
        String email = emp.generateEmail();
        System.out.println(email);
    }
}
