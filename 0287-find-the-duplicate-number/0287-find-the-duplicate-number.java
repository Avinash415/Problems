class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        // first phase detection block
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow != fast);

        // second phase : entry point

        slow=nums[0];

        while(slow != fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }
}