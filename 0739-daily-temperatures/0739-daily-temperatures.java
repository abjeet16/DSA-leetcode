class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];
        for(int i = n-1 ; i >= 0 ;i--){
            //System.out.println(st);
            while(!st.isEmpty()&&temp[st.peek()]<=temp[i])st.pop();

            if(st.isEmpty())res[i] = 0;
            else res[i]=st.peek()-i;
            st.push(i);
        }
        return res;
    }
}