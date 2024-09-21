class Calculator {
        // Method Overloading
        public int add(int a, int b) {
            return a + b;
        }
        public double add(double a, double b) {
            return a + b;
        }
        // Constructor Overloading
        public Calculator() {
            System.out.println("Default Constructor");
        }
        public Calculator(int num) {
            System.out.println("Constructor with one integer parameter: " + num);
        }
        public Calculator(double num1, double num2) {
            System.out.println("Constructor with two double parameters: " + num1 + " and " + num2);
        }     
}
public class ex2Overloading {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // Method overloading examples
        int result1 = calculator.add(5, 10);
        System.out.println("Result 1: " + result1);
        double result2 = calculator.add(2.5, 3.5);
        System.out.println("Result 2: " + result2);
        // Constructor overloading examples
        Calculator cal1 = new Calculator();
       Calculator cal2 = new Calculator(5);
        Calculator cal3 = new Calculator(2.5, 3.5);
        cal1.add(0.1, 0.2);
        cal2.add(0.1,0.2);
        cal3.add(0.1, 0.2);


    }
}
