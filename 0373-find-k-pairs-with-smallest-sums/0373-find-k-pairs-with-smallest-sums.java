class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
    );

    for (int i = 0; i < Math.min(k, nums1.length); i++) {
        minHeap.offer(new int[]{i, 0});
    }

    while (k-- > 0 && !minHeap.isEmpty()) {
        int[] indices = minHeap.poll();
        int i = indices[0], j = indices[1];

        result.add(Arrays.asList(nums1[i], nums2[j]));

        if (j + 1 < nums2.length) {
            minHeap.offer(new int[]{i, j + 1});
        }
    }

    return result;
    }
}