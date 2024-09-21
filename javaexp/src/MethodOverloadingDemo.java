public class MethodOverloadingDemo {
    // Overloaded method with two integer parameters
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three integer parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method with two double parameters
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method with a String parameter
    public String add(String str1, String str2) {
        return str1 + str2;
    }

    public static void main(String[] args) {
        MethodOverloadingDemo demo = new MethodOverloadingDemo();

        // Call the overloaded methods and demonstrate static binding
        int sum1 = demo.add(5, 10);
        int sum2 = demo.add(5, 10, 15);
        double sum3 = demo.add(3.5, 4.5);
        String concatenatedString = demo.add("Hello, ", "world!");

        // Print the results
        System.out.println("Sum of two integers: " + sum1);
        System.out.println("Sum of three integers: " + sum2);
        System.out.println("Sum of two doubles: " + sum3);
        System.out.println("Concatenated string: " + concatenatedString);
    }
}

