class Solution {
    private PriorityQueue<Integer> fillQ(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item: arr){
            pq.offer(item);
        }
        return pq;
    }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        //step1: thinking of greedy approach
        //step2: mapping the player with the lowest capity of trainee 
        //step3
        PriorityQueue<Integer> playersQ = fillQ(players);
        PriorityQueue<Integer> traineeQ = fillQ(trainers);
        int matches = 0;
        while(!playersQ.isEmpty() && !traineeQ.isEmpty()){
            int ability = playersQ.poll();
            if(traineeQ.peek() >= ability){
                matches++;
                traineeQ.poll();
                continue;
            }
            while(!traineeQ.isEmpty() && traineeQ.peek() < ability){
                traineeQ.poll();
            }
            if(!traineeQ.isEmpty() && traineeQ.peek() >= ability){
                matches++;
                traineeQ.poll();
            }
        }
        
        return matches;
    }
}