class Solution {
    public int findMin(int[] nums) {
       if (nums == null || nums.length == 0) throw new IllegalArgumentException("Empty array");
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                // minimum is at mid or to the left of mid
                right = mid;
            } else {
                // minimum is to the right of mid
                left = mid + 1;
            }
        }
        return nums[left]; 
    }
}