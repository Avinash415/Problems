class Solution {
    public boolean findSubarrays(int[] nums) {
        // base case..
        if(nums.length < 2) return false;
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<nums.length-1; i++){
            int sum=nums[i]+nums[i+1];
            if(map.getOrDefault(sum, 0) > 0){
                return true;
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return false;
    }
}