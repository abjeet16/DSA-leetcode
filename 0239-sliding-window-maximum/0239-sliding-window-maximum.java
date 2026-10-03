class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(i = 0 ; i < k ; i++){
            q.offer(new int[]{i,nums[i]});
        }
        int size = nums.length+1-k;
        int[] res = new int[size];
        for(i = 0 ; i < Math.min(k,size) ; i++){
            res[i] = q.peek()[1];
        }

        for(i = k ; i < nums.length ; i++){
            q.offer(new int[]{i,nums[i]});
            j++;
            while(q.peek()[0]<j){
                q.poll();
            }
            res[j] = q.peek()[1];
        }
        return res;
    }
}