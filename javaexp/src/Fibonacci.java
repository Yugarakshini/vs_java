public class Fibonacci {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        int fibPrev = 0;
        int fibCurr = 1;
for (int i = 2; i <= n; i++) {
            int temp = fibCurr;
            fibCurr = fibPrev + fibCurr;
            fibPrev = temp;
        }
        return fibCurr;
    }

public static void main(String[] args) {
        int n = 10; // Change 'n' to get different Fibonacci numbers
        System.out.println("Fibonacci series using recursive function:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
        System.out.println("Fibonacci series using non-recursive function:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciNonRecursive(i) + " ");
        }
    }
    
}
