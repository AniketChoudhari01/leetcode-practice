class FoodRatings {
    public class Pair {
        int val;
        String str;

        public Pair(int val, String str) {
            this.val = val;
            this.str = str;
        }
    }

    private Comparator<Pair> myComp = (a, b)->
    {
        if (a.val != b.val)
            return Integer.compare(b.val, a.val);
        else
            return a.str.compareTo(b.str);//return the lexicographically smalleststring
    };

    Map<String, PriorityQueue<Pair>> map = new HashMap<>();
    Map<String, String> foodToCuisine = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();//keeps track of updated rating for a given food

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            map.putIfAbsent(cuisines[i], new PriorityQueue<>(myComp));
            map.get(cuisines[i]).offer(new Pair(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);//update the ratings

        String cuisine = foodToCuisine.get(food);
        // if (map.containsKey(cuisine)) {
        //     map.get(cuisine).remove(food);
        map.get(cuisine).offer(new Pair(newRating, food));//pushing new pair
        // }
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = map.get(cuisine);
        while (true) {
            Pair top = pq.peek();
            //check if the current cuisine rating matches with the changed one if any
            if (foodToRating.get(top.str) == top.val)
                return top.str;
            else
                pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */