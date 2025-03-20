class StockPrice {
    HashMap<Integer, Integer> hm;// time, price
    TreeMap<Integer, Integer> freq_map;// price,instance
    TreeMap<Integer, Integer> tm; // time, price

    public StockPrice() {
        this.hm = new HashMap<>();
        this.freq_map = new TreeMap<>();
        this.tm = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (hm.containsKey(timestamp)) {
            int old_price = hm.get(timestamp);
            freq_map.put(old_price, freq_map.get(old_price) - 1);
            if (freq_map.get(old_price) == 0) {
                freq_map.remove(old_price);
            }
        }
        tm.put(timestamp, price);
        hm.put(timestamp, price);
        freq_map.put(price, freq_map.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return tm.lastEntry().getValue();
    }

    public int maximum() {
        return freq_map.lastEntry().getKey();
    }

    public int minimum() {
        return freq_map.firstEntry().getKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */