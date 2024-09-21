public class ex4PalindromeChecker {
    public static void main(String[] args) {
        String input = "madama"; // Replace this with your input string
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}
