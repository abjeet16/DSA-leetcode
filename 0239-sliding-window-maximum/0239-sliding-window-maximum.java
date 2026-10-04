class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int n = nums.length;
        int[] res = new int[n+1-k];
        ArrayDeque<Integer>  q = new ArrayDeque<>();
        while(i<n){
            while(!q.isEmpty()&&q.peekLast()<nums[i])q.pollLast();

            q.add(nums[i]);

            if(i-j+1<k){
                i++;
            }else{
                res[idx]=q.peek();
                if(q.peek()==nums[j])q.pollFirst();
                idx++;
                i++;
                j++;
            }
        }
        return res;
    }
}