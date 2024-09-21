abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();
    // Concrete method (non-abstract) to display a message
    public void displayMessage() {
        System.out.println("This is a shape.");
    }
}
// Concrete subclass Circle that extends the abstract class Shape
class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    // Implementing the abstract method for calculating the area of a circle
        public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
// Concrete subclass Rectangle that extends the abstract class Shape
class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    // Implementing the abstract method for calculating the area of a rectangle
    public double calculateArea() {
        return length * width;
    }
}

public class ex5abstractclass {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 3.0);
        circle.displayMessage();
        System.out.println("Area of Circle: " + circle.calculateArea());
        rectangle.displayMessage();
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
    }

    
}
