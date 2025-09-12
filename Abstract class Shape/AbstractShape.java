import java.util.Scanner;

abstract class Shape {
    public abstract double area();

    public abstract double perimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double perimeter() {
        return 2 * (Math.PI * radius);
    }

}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double perimeter() {
        return 2 * (length + breadth);
    }
}

class AbstractShape {
    public static void main(String[] args) {
        Shape circle = new Circle(12);
        Shape rectangle = new Rectangle(10, 20);

        System.out.println("Area and Perimeter of circle \n");
        System.out.println(circle.area() + "," + circle.perimeter());
        System.out.println("\nArea and perimeter of Rectangle \n");
        System.out.println(rectangle.area() + "," + rectangle.perimeter());
    }
}