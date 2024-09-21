class Employee {
    protected String name;
    protected int employeeId;
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
    public void calculateSalary() {
        // Salary calculation logic for general employees (to be overridden by subclasses)
    }
}
class SalariedEmployee extends Employee {
    private double monthlySalary;
    public SalariedEmployee(String name, int employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }
    public void calculateSalary() {
        System.out.println()
        super.displayDetails();
        System.out.println("Monthly Salary: $" + monthlySalary);
    }
}
class HourlyEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    public HourlyEmployee(String name, int employeeId, int hoursWorked, double hourlyRate) {
        super(name, employeeId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    public void calculateSalary() {
        System.out.println("Salary Slip for Hourly Employee");
        super.displayDetails();
        double salary = hoursWorked * hourlyRate;
        System.out.println("Total Salary: $" + salary);
    }
}

public class payslip {
    public static void main(String[] args) {
        // Create salaried employee
        SalariedEmployee salariedEmployee = new SalariedEmployee("John Smith", 1001, 5000);
        salariedEmployee.displayDetails();
        salariedEmployee.calculateSalary();
        System.out.println();
        // Create hourly employee
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Jane Doe", 2002, 160, 15);
        hourlyEmployee.calculateSalary();
    }

    
}
