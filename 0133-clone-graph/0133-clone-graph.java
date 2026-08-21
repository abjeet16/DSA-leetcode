/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map.put(node,new Node(node.val));
        while(!q.isEmpty()){
            Node org = q.poll();
            Node copy = map.get(org);
            List<Node> list = copy.neighbors;
            for(Node nb : org.neighbors){
                if(!map.containsKey(nb)){
                    map.put(nb,new Node(nb.val));
                    q.offer(nb);
                }
                list.add(map.get(nb));
            }
        }
        return map.get(node);
    }
}