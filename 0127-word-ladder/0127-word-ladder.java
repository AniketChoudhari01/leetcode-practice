class Solution {
    class Pair {
        String word;
        int steps;

        public Pair(String a, int b) {
            this.word = a;
            this.steps = b;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList) {
            set.add(str);
        }
        int ans = 0;
        // int wordLen = beginWord.length();
        Queue<Pair> q = new LinkedList<>();
        Pair firstPair = new Pair(beginWord, 1);
        q.offer(firstPair);
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            String str = pair.word;
            int currStep = pair.steps;
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                for (int j = 0; j < 26; j++) {
                    sb.setCharAt(i, (char) ('a' + j));
                    // if(str.equals("dog")){
                    //     System.out.println(" "+sb.toString());
                    // }
                    if (set.contains(sb.toString())) {
                        if (sb.toString().equals(endWord))
                            return currStep + 1;
                        set.remove(sb.toString());
                        Pair tempPair = new Pair(sb.toString(), currStep + 1);
                        q.offer(tempPair);
                    }
                }
                // for(Pair wp: q){
                //     System.out.println("after hunt :"+wp.word+" , "+wp.steps);

                // }
                // System.out.println("------");
            }
        }
        return 0;
    }
}