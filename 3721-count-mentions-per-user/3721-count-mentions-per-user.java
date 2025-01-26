class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = events.size();
        int mentionsArr[] = new int[numberOfUsers];
        Map<Integer, Integer> offUser = new HashMap<>();
        int total = 0;
        events.sort( (list1, list2)->{
            if(Integer.parseInt(list1.get(1))<Integer.parseInt(list2.get(1))){
                return -1;
            }else if(Integer.parseInt(list1.get(1)) == Integer.parseInt(list2.get(1))){
                if(list1.get(0).equals("OFFLINE")){
                    return -1;
                }else if(list2.get(1).equals("OFFLINE")){
                    return 1;
                }else{
                    return 0;
                }
            }else {
                return 1;
            }

        });
        // for(List<String> list: events){
        //     System.out.println("li: "+list);
        // }
        for (List<String> list : events) {
            String msg = list.get(0);
            String ts = list.get(1);
            String mention = list.get(2);
            // System.out.println(msg+" , "+ts+" , "+mention);
            if (mention.equals("ALL")) {
                total++;
            } else if (msg.equals("OFFLINE")) {
                offUser.put(Integer.parseInt(mention), Integer.parseInt(ts) + 60);
            } else if (mention.equals("HERE")) {
                int curr = Integer.parseInt(ts);
                Iterator<Map.Entry<Integer, Integer>> iterator = offUser.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    int key = entry.getKey();
                    int val = entry.getValue();
                    if (curr < val) {
                        // System.out.println("key: "+key);
                        mentionsArr[key]--;
                    }
                    if (curr >= val) {
                        iterator.remove(); // Safe removal
                    }
                }
                total++;
            } else if (msg.equals("MESSAGE")) {
                String temp[] = mention.split(" ");
                for (String str : temp) {
                    // int id = str.charAt(2) - '0'; what for "id12"
                    int id = Integer.parseInt(str.substring(2));
                    // System.out.println("id: "+id);
                    mentionsArr[id]++;
                }
            }
        }

        for (int i = 0; i < numberOfUsers; i++) {
            mentionsArr[i] += total;
        }

        return mentionsArr;
    }
}