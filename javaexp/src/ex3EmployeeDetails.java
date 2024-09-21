import java.util.Scanner;
class Employee {
    private String name;
    private int age;
    private String designation;
    private double salary;
    public Employee(String name, int age, String designation, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getDesignation() {
        return designation;
    }
    public double getSalary() {
        return salary;
    }
}


public class ex3EmployeeDetails {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        // Creating the Employee object with user input
        Employee employee = new Employee(name, age, designation, salary);
        // Displaying employee details
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Salary: " + employee.getSalary());
        scanner.close();
    }

}
