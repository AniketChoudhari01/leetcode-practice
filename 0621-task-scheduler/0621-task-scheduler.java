class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char ch: tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b)-> Integer.compare(b, a)
        );
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }
        int time = 0;
        List<Integer> list;
        while(!pq.isEmpty()){
            int cycle = n + 1;
            int task_cnt = 0;
            list = new ArrayList<>();
            while(cycle-- > 0 && !pq.isEmpty()){
                task_cnt++;
                int num = pq.poll();
                if(num > 1){
                    list.add(num - 1);
                }
            }
            for(int item: list){
                pq.add(item);
            }
            if(!pq.isEmpty()){//there are some elems
                time += (n+1);
            }else{
                time += task_cnt;
            }
        }
        return time;
    }
}