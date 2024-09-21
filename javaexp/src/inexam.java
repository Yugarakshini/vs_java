

interface Shape {
    void draw(); // Abstract method
}
// Abstract class implementing the Shape interface
abstract class AbstractShape implements Shape {
    public void draw() {
        System.out.println("Drawing a shape.");
    }
    // Abstract method
    abstract void calculateArea();
}
// Concrete class Rectangle that extends AbstractShape
class Rectangle extends AbstractShape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}
// Concrete class Circle that extends AbstractShape
class Circle extends AbstractShape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

public class inexam {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4.0, 3.0);
        Shape circle = new Circle(5.0);
        rectangle.draw(); // This will call AbstractShape's draw method
        ((AbstractShape) rectangle).calculateArea(); // Call Rectangle's calculateArea method
        circle.draw(); // This will call AbstractShape's draw method
        ((AbstractShape) circle).calculateArea(); // Call Circle's calculateArea method
    }

    
}
