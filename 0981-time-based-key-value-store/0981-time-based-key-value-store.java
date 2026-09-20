class Pair{
    String value;
    int time;

    Pair(String v,int t){
        value = v;
        time = t;
    }

}
class TimeMap {
    Map<String,ArrayList<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int time) {
        ArrayList<Pair> l = map.getOrDefault(key,new ArrayList<>());
        l.add(new Pair(value,time));
        map.put(key,l);
    }
    
    public String get(String key, int time) {
        return find(map.getOrDefault(key,new ArrayList()),time);
    }
    private String find(ArrayList<Pair> l,int time){
        int i = 0;
        int j = l.size()-1;
        int res = -1;
        while(i<=j){
            int mid = (i+j)/2;
            Pair p = l.get(mid);
            if(p.time<=time){
                res = mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return res==-1?"":l.get(res).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */