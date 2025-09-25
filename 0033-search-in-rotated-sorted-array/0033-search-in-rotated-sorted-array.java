class Solution {
    public int search(int[] nums, int target) {
        
       if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // If left..mid is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    // target in left sorted part
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // else mid..right must be sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    // target in right sorted part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}