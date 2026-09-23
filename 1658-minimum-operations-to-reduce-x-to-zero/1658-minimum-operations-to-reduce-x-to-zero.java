class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i]>x||sum+nums[i]>x)break;
            sum+=nums[i];
            if(sum==x){
                res = i+1;
                break;
            }
            map.put(sum,i+1);
        }
        //System.out.println(map);
        sum = 0;
        for(int i = n -1 ; i >= 0 ; i--){
            if(n-i>res)break;
            if(nums[i]>x||sum+nums[i]>x)break;
            sum+=nums[i];
            if(sum==x){
                res = Math.min(res,n-i);
                //break;
            }
            int req = x-sum;
            if(map.containsKey(req)){
                //System.out.println(map.get(req)+" "+(n-i));
                res = Math.min(res,map.get(req)+n-i);
                //break;
            }
        }
        //System.out.println(map);
        return res>nums.length?-1:res;
    }
}