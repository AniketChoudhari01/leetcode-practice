class ProductOfNumbers {
    List<Integer> zeroIdx = new ArrayList<>();
    List<Integer> prefixProd = new ArrayList<>();
    int x = 1; 

    public ProductOfNumbers() {
        prefixProd.add(1); // Initialize prefix product for easier division
    }

    public void add(int num) {
        if (num == 0) {
            zeroIdx.add(prefixProd.size()); 
            x = 1; 
            prefixProd.add(1);
        } else {
            x *= num;
            prefixProd.add(x);
        }
    }

    public int getProduct(int k) {
        int len = prefixProd.size();
        if (!zeroIdx.isEmpty() && zeroIdx.get(zeroIdx.size() - 1) >= len - k)
            return 0;

        return prefixProd.get(len - 1) / prefixProd.get(len - k - 1);
    }
}
