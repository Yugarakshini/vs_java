public class MinShift {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "llohe";

        // Calculate right shifts
        int rightShift = calculateRightShift(s1, s2);
        // Calculate left shifts
        int leftShift = calculateLeftShift(s1, s2);

        // Determine which shift is smaller
        if (rightShift < leftShift) {
            System.out.println("R" + rightShift);
        } else if (leftShift < rightShift) {
            System.out.println("L" + leftShift);
        } else {
            System.out.println("A" + rightShift); // or leftShift since both are same
        }
    }

    // Calculate right shifts required
    public static int calculateRightShift(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.equals(s2)) {
                return i;
            }
            s1 = s1.charAt(s1.length() - 1) + s1.substring(0, s1.length() - 1); // Right shift
        }
        
        return s1.length();
    }

    // Calculate left shifts required
    public static int calculateLeftShift(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.equals(s2)) {
                return i;
            }
            s1 = s1.substring(1) + s1.charAt(0); // Left shift
        }
        return s1.length();
    }
}
