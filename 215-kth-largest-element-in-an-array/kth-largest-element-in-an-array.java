import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for (int num : nums) {
            minH.offer(num);

            if (minH.size() > k) {
                minH.poll();
            }
        }

        return minH.peek();
    }
}