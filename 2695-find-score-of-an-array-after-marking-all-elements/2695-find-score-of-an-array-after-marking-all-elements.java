class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        boolean visited[] = new boolean[nums.length];
        TreeMap<Integer, PriorityQueue<Integer>> eleIndexMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!eleIndexMap.containsKey(nums[i])) {
                eleIndexMap.put(nums[i], new PriorityQueue<Integer>());
            }
            eleIndexMap.get(nums[i]).offer(i);
        }
        // System.out.println(eleIndexMap);
        for (Map.Entry<Integer, PriorityQueue<Integer>> item : eleIndexMap.entrySet()) {
            PriorityQueue<Integer> pq = item.getValue();

            while (!pq.isEmpty()) {
                score += item.getKey();
                int popped = pq.poll();
                visited[popped] = true;
                if (popped - 1 >= 0 && !visited[popped - 1]) {
                    visited[popped - 1] = true;
                    eleIndexMap.get(nums[popped - 1]).remove(popped - 1);
                }
                if (popped + 1 < n && !visited[popped + 1]) {
                    visited[popped + 1] = true;
                    eleIndexMap.get(nums[popped + 1]).remove(popped + 1);
                }
                // System.out.println("key: " + item.getKey() + " after : " + eleIndexMap);

            }
            // System.out.println("key:"+item.getKey()+" value: "+item.getValue());
        }
        return score;
    }
}