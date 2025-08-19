class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] lmax = new int[n];
        lmax[0] = arr[0];

        // Compute left max array
        for (int i = 1; i < n; i++) 
            lmax[i] = Math.max(lmax[i - 1], arr[i]);

        int rmax = arr[n - 1], ans = 0;

        // Compute trapped water while updating right max dynamically
        for (int i = n - 1; i >= 0; i--) {
            rmax = Math.max(rmax, arr[i]);
            ans += Math.min(lmax[i], rmax) - arr[i];
        }
        return ans;
    }
}