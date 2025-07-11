class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int rooms[] = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> roomsQ = new PriorityQueue<>();//keeps track of rooms available
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            } else {
                return Long.compare(a[1], b[1]);
            }
        });
        //keeps track of end time and the alloted room for it
        for (int i = 0; i < n; i++) {
            roomsQ.offer(i);
        }

        long time = 0;
        for (int meet[] : meetings) {
            //put all the meetings into roomsQ that got free till current start time
            while (!pq.isEmpty() && pq.peek()[0] <= meet[0]) {
                long roomNo = pq.poll()[1];
                roomsQ.offer((int)roomNo);
            }

            if (!roomsQ.isEmpty()) {
                //the problem may come here when we are keep on filling the rooms as they are available for large n
                //but the case earlier rooms are vacant 
                int roomNo = roomsQ.poll();
                //then simply allocated the room
                rooms[roomNo]++;
                // mostMeetings = Math.max(mostMeetings, rooms[roomNo]);
                pq.offer(new long[] { meet[1], roomNo });
            } else {
                long pair[] = pq.poll();//remove the early finishing job based on end time then based on lower room number
                time = pair[0];
                long duration = meet[1] - meet[0];
                // if (time >= meet[0]) {//if the meeting is delayed
                pq.offer(new long[] { time + duration, pair[1] });
                // } else {
                //     pq.offer(new int[] { meet[1], pair[1] });
                // }
                rooms[(int)pair[1]]++;//inc meet occured in room i
            }
        }
        int maxRoom = 0;
        for (int i = 0; i < n; i++) {
            if(rooms[i] > rooms[maxRoom]){
                maxRoom = i;
            }
        }
        // System.out.println(Arrays.toString(rooms));
        return maxRoom;
    }
}