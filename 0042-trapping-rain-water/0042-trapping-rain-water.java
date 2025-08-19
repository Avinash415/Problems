class Solution {
    public int trap(int[] arr) {
        int l = 0, r = arr.length - 1;
        int lmax = 0, rmax = 0, ans = 0;

        while (l < r) {
            lmax = Math.max(lmax, arr[l]);
            rmax = Math.max(rmax, arr[r]);

            if (lmax < rmax) {
                ans += lmax - arr[l];
                l++;
            } else {
                ans += rmax - arr[r];
                r--;
            }
        }
        return ans;
    }
}