class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        ArrayList<Integer>[] freq = new ArrayList[26];
        for(int i = 0 ; i < 26 ; i++)freq[i] = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            freq[ch-'a'].add(i);
        }

        for(ArrayList<Integer> i : freq){
            //System.out.println(i);
        }

        for(String str : words){
            boolean yes = true;
            int lastIn = -1;
            for(char ch : str.toCharArray()){
                int idx = find(ch,freq[ch-'a'],lastIn);
                //System.out.println(ch+" "+idx);
                if(idx==-1){
                    yes = false;
                    break;
                }
                lastIn = idx+1;
            }
            if(yes)res++;
        }
        return res;
    }
    private int find(char ch , ArrayList<Integer> list,int target){
        //System.out.println(ch+" "+list);
        int low = 0;
        int high = list.size()-1;
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target<=list.get(mid)){
                res = list.get(mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        //System.out.println(res);
        return res;
    }
}