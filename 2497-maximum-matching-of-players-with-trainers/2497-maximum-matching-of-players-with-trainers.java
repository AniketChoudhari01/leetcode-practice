class Solution {
    // private PriorityQueue<Integer> fillQ(int arr[]){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int item: arr){
    //         pq.offer(item);
    //     }
    //     return pq;
    // }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        //step1: thinking of greedy approach
        //step2: mapping the player with the lowest capity of trainee 
        //step3
        // PriorityQueue<Integer> playersQ = fillQ(players);//O(n*logn)
        // PriorityQueue<Integer> traineeQ = fillQ(trainers);//O(n*logn)
        // int matches = 0;
        // while(!playersQ.isEmpty() && !traineeQ.isEmpty()){//at max will run till O(n)
        //     int ability = playersQ.poll();
        //     if(traineeQ.peek() >= ability){
        //         matches++;
        //         traineeQ.poll();
        //         continue;
        //     }
        //     while(!traineeQ.isEmpty() && traineeQ.peek() < ability){
        //         traineeQ.poll();
        //     }
        //     if(!traineeQ.isEmpty() && traineeQ.peek() >= ability){
        //         matches++;
        //         traineeQ.poll();
        //     }
        // }

        //method 2
        //sort them
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matches = 0;
        int m = players.length, n = trainers.length;
        for(int i = 0, j = 0; i<m && j<n ;i++){
            int ability = players[i];
            while(j<n && trainers[j] < ability){
                j++;
            }
            if(j<n && trainers[j] >=  ability){
                j++;
                matches++;
            }
        }
        
        return matches;
    }
}