class Solution {
    class Pair{
        char ch;
        int val;
        public Pair(char ch, int val){
            this.ch = ch;
            this.val = val;
        }
    }
    public String reorganizeString(String s) {
        if(s.length() == 1) return s;
        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.val != b.val){
                    return Integer.compare(b.val, a.val);
                }else{
                    return Integer.compare(a.ch, b.ch);
                }
            }
        );
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        if(hm.size() == 1) return "";
        for(Map.Entry<Character, Integer> item:hm.entrySet()){
            pq.offer(new Pair(item.getKey(), item.getValue()));
        }
        while(pq.size() > 1){
            Pair pair = pq.poll();
            sb.append(pair.ch);
            int temp2 = pair.val - 1;
            if(!pq.isEmpty()){
                Pair p = pq.poll();
                sb.append(p.ch);
                int temp = p.val - 1;
                if(temp != 0){
                    pq.offer(new Pair(p.ch, temp));
                }
            }
            if(temp2 != 0){
                pq.offer(new Pair(pair.ch, temp2));
            }
        }
        if(!pq.isEmpty()){
            if(pq.peek().val > 1) return "";
            Pair p = pq.poll();
            if(sb.charAt(sb.length()-1) == p.ch) return "";
            sb.append(p.ch);
        }
        return sb.toString();
    }
}