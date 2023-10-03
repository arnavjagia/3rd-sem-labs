/*
Create a Building class and two subclasses, House and School. The Building class contains fields for square footage and stories. The House class contains additional fields for number of bedrooms and baths. The School class contains additional fields for number of classrooms and grade level (for example, elementary or junior high). All the classes contain appropriate get and set methods. Create a main method that declares objects of each type.
*/

import java.util.*;

class Building {
    private double sqFeet;
    private int stories; 

    // getter and setter for sqFeet
    double getSqFeet() { return sqFeet; }
    void setSqFeet(double sft) { sqFeet = sft; }

    // getter and setter for stories
    int getStories() { return stories; }
    void setStories(int s) { stories = s; }
}

class House extends Building {
    private int bedrooms, baths;

    // getter and setter for bedrooms
    int getBedrooms() {return bedrooms;}
    void setBedrooms(int bd) {bedrooms = bd;}

    // getter and setter for baths
    int getBaths() {return baths;}
    void setBaths(int b) {baths = b;}
}

class School extends Building {
    private int clas;
    private String grade;

    // getter and setter for clas
    int getClas() {return clas;}
    void setClas(int c) {clas = c;}

    // getter and setter for grade
    String getGrade() {return grade;}
    void setGrade(String grd) {grade = grd;}
}

public class q4Building {
    public static void main(String[] args) {
        Building oBuild = new Building();
        House oHouse = new House();
        School oSchool = new School();

        Scanner sc = new Scanner(System.in);

        System.out.print("sqFeet: ");
        oBuild.setSqFeet(sc.nextDouble());
        System.out.print("#stories: ");
        oBuild.setStories(sc.nextInt());
        
        System.out.print("#bedrooms: ");
        oHouse.setBedrooms(sc.nextInt());
        System.out.print("#baths: ");
        oHouse.setBaths(sc.nextInt());

        System.out.print("#classrooms: ");
        oSchool.setClas(sc.nextInt());
        System.out.print("grade: ");
        sc.nextLine();
        oSchool.setGrade(sc.nextLine());
        sc.close();

        System.out.println("\nBuilding\nsqft: " + oBuild.getSqFeet() + "\t#stories: " + oBuild.getStories()
                + "\nHouse\n#bedrms: " + oHouse.getBedrooms() + "\t#baths: " + oHouse.getBaths()
                + "\nSchool\n#class: " + oSchool.getClas() + "\tgrade: " + oSchool.getGrade());
    }
}
