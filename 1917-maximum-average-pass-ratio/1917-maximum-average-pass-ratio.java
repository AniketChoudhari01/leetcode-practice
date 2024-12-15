class Solution {

    public class storeIndex {
        double difference;
        int index;

        public storeIndex(double difference, int index) {
            this.difference = difference;
            this.index = index;
        }
    }

    private double difference(int passes, int total) {
        return ((double)(passes+1)/(total+1)) - ((double)passes/total);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<storeIndex> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.difference, a.difference));

        for (int i = 0; i < classes.length; i++) {
            Double improvement = difference(classes[i][0], classes[i][1]);
            pq.offer(new storeIndex(improvement, i));
        }
        while (extraStudents-- > 0) {
            storeIndex best = pq.poll();
            int idx = best.index;
            classes[idx][0]++;
            classes[idx][1]++;
            Double improvement = difference(classes[idx][0], classes[idx][1]);
            pq.offer(new storeIndex(improvement, idx));
        }

        double averagePassRatio = 0;
        for (int[] arr : classes) {
            averagePassRatio += ((double) arr[0] / arr[1]);
        }
        return Math.round((averagePassRatio / classes.length) * 100000.0) / 100000.0;
    }
}