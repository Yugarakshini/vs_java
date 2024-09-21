public class RotatedSortedArray {

    public int run(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid; 
            }


            if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1; // If the target is not found
    }

    public static void main(String[] args) {
        RotatedSortedArray rsa = new RotatedSortedArray();
        int[] nums = {3, 4, 7, 9, 1, 2};
        int result = rsa.run(nums, 1);
        System.out.println(result); // Should print the index of target if found, or -1 if not
    }
}
