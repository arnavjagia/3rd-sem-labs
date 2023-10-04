/*
Create an abstract class Figure with abstract method area and two integer dimensions. Create three more classes Rectangle, Triangle and Square which extend Figure and implement the area method. Show how the area can be computed dynamically during run time for Rectangle, Square and Triangle to achieve dynamic polymorphism. (Use the reference of Figure class to call the three different area methods)
*/
import java.util.*;

abstract class Figure {
    double dim1, dim2;
    void getDim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dimension 1 for "+this+" : ");
        dim1 = sc.nextDouble();
        System.out.print("Dimension 2 for "+this+" : ");
        dim2 = sc.nextDouble();
    }
    abstract double area();
}

class Rectangle extends Figure {
    double area() {
        return dim1 * dim2;
    }
    @Override
    public String toString() {return "Rectangle";}
}

class Triangle extends Figure {
    double area() {
        return 0.5 * dim1 * dim2;
    }
    @Override
    public String toString() {return "Triangle";}
}

class Square extends Figure {
    double area() {
        return dim1 * dim2;
    }
    @Override
    public String toString() {return "Square";}
}

public class q5Figure {
    public static void main(String[] s) {
        // fig a rect
        Figure fig = new Rectangle();
        fig.getDim();
        System.out.println(fig.area());
        // fig a triangle
        fig = new Triangle();
        fig.getDim();
        System.out.println(fig.area());
        //fig a square
        fig = new Square();
        fig.getDim();
        System.out.println(fig.area());
    }
}