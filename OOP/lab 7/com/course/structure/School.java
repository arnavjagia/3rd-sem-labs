package com.course.structure;

public class School extends Building {
    private int clas;
    private String grade;

    // getter and setter for clas
    public int getClas() {return clas;}
    public void setClas(int c) {clas = c;}

    // getter and setter for grade
    public String getGrade() {return grade;}
    public void setGrade(String grd) {grade = grd;}
}