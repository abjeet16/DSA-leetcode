class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxres = Integer.MIN_VALUE;
        int minres = Integer.MAX_VALUE;

        int maxSum = 0;
        int minSum = 0;

        int total = 0;

        for (int i : nums) {
            total += i;

            maxSum += i;
            maxres = Math.max(maxres, maxSum);
            if (maxSum < 0)
                maxSum = 0;

            minSum += i;
            minres = Math.min(minres, minSum);
            if (minSum > 0)
                minSum = 0;
        }
        if(maxres<0)return maxres;
        return Math.max(maxres, total - minres);
    }
}