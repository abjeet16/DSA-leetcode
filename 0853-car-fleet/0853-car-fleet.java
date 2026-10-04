class Pair {
    int pos;
    int sp;

    Pair(int p, int s) {
        pos = p;
        sp = s;
    }

    public String str() {
        return pos + " " + sp;
    }
}

class Solution {
    public int carFleet(int target, int[] pos, int[] sp) {
        int n = pos.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(pos[i], sp[i]);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b.pos, a.pos));
        //display(p);
        Stack<Float> st = new Stack<>();

        for(Pair pair : pairs){
            float dis = target - pair.pos;
            float time = dis/pair.sp;
            //System.out.println(time);
            if(st.isEmpty()||st.peek()<time){
                st.push(time);
            }
        }

        return st.size();
    }

    private void display(Pair[] p) {
        for (Pair i : p)
            System.out.println(i.str());
    }
}