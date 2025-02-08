class NumberContainers {
    Map<Integer, Integer> idxElemMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> elemIdx = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int idx, int number) {
        if (idxElemMap.containsKey(idx)) {
            int oldNum = idxElemMap.get(idx);
            TreeSet<Integer> oldSet = elemIdx.get(oldNum);
            oldSet.remove(idx);
            if(oldSet.isEmpty()){
                elemIdx.remove(oldNum);
            }
        }
        idxElemMap.put(idx, number);
        elemIdx.putIfAbsent(number, new TreeSet<>());
        elemIdx.get(number).add(idx);
    }

    public int find(int number) {
        //for check existence of key priority queue takes o(n) time while TreeSet takes O(log(n)) time
        TreeSet<Integer> set = elemIdx.get(number);
        return (set == null || set.isEmpty())? -1 : set.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */