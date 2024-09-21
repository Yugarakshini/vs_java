import java.util.Scanner;

public class multiblock {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(scanner.nextLine());
            int result = 100 / num;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero is not allowed.");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Invalid number format entered.");
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred.");
        } finally {
            scanner.close();
            System.out.println("Finally block executed.");
        }
    }

    
}
