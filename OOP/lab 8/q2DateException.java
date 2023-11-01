/*
Define a class CurrentDate with data members day, month and year. Define a method createDate() to create date object by reading values from keyboard. Throw a user defined exception by name InvalidDayException if the day is invalid and InvalidMonthException if month is found invalid and display current date if the date is valid. Write a test program to illustrate the functionality.
*/

import java.util.*;

class InvalidDayException extends Exception {
    public String toString() { return "Invalid day"; }
}

class InvalidMonthException extends Exception {
    public String toString() { return "Invalid month"; }
}

class CurrentDate {
    int day, month, year;

    CurrentDate() {
        day = month = year = 0;
    }

    void createDate() throws InvalidDayException, InvalidMonthException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day: ");
        day = sc.nextInt();
        if (day < 1 || day > 31) throw new InvalidDayException();
        System.out.print("Enter month: ");
        month = sc.nextInt();
        if (month < 1 || month > 12) throw new InvalidMonthException();
        System.out.print("Enter year: ");
        year = sc.nextInt();
    }

    void display() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }
}

class q2DateException{
    public static void main(String[] args) {
        CurrentDate d = new CurrentDate();
        try {
            d.createDate();
            d.display();
        } catch (InvalidDayException e) {
            System.out.println(e);
        } catch (InvalidMonthException e) {
            System.out.println(e);
        }
    }
}

/* ------------------------------- SAMPLE --------------------------------   
Enter day: 5
Enter month: 10
Enter year: 2023
Date: 5/10/2023
*/