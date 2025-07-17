class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, maxLen=0;
        Set<Character> set=new HashSet<>();

        for(int right=0; right < s.length(); right++){
            // Shrinking ...
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));   // Expanding the windows
            maxLen=Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}