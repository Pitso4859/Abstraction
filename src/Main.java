import java.awt.Color;

abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void displayInfo() {
        System.out.println("This is a " + name + " shape");
        System.out.println("Area: " + calculateArea());
    }
}

// Circle class
class Circle extends Shape {
    double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    double width;
    double length;

    public Rectangle(String name, double width, double length) {
        super(name);
        this.width = width;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Interface
interface Drawable {
    void draw();

    default void setColor(Color color) {
        System.out.println("Setting color " + color);
    }
}

// Triangle class
class Triangle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle("My Circle", 5.0);
        circle.displayInfo();

        Rectangle rectangle = new Rectangle("My Rectangle", 4.0, 6.0);
        rectangle.displayInfo();

        Triangle triangle = new Triangle();
        triangle.draw();
        triangle.setColor(Color.BLUE);
    }
}