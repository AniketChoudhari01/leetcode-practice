class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // sort based on first index
        // have max so far var
        // have a map to fill price , max beauty
        // if map doesn't contains price return 0
        // 1,2; 2,4; 3,5;
        // can I have an array of 10^5+1 size filled with all 0
        // start from 1
        // [[1,2],[2,4],[3,2],[3,5],[5,6]]
        // 100,00,00,001
        // int queryAns[]=new int[100_00_00_000];
        TreeMap<Integer, Integer> map = new TreeMap<>();// price ,value map
        int maxi = Integer.MIN_VALUE;
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int[] a : items) {
            maxi = Math.max(maxi, a[1]);
            map.put(a[0], maxi);
        }
        int arr[] = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            arr[i++] = item.getKey();
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(arr));
        for (int j = 0; j < queries.length; j++) {

            // if (bound != -1) {
            // queries[j] = map.get(mapKey);
            // }
            if (queries[j] > arr[arr.length - 1]) {
                queries[j] = map.get(arr[arr.length - 1]);
            } else if (queries[j] < arr[0]) {
                queries[j] = 0;
            } else {
                int low = 0, high = arr.length - 1;
                int mapKey = -1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] == queries[j]) {
                        mapKey = arr[mid];
                        break;
                    } else if (arr[mid] <= queries[j]) {
                        mapKey = arr[mid];
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                if (mapKey != -1) {
                queries[j] = map.get(mapKey);
                }
            }
        }

        // System.out.println(map);
        // int curr=0;
        // for(int i=0;i<queryAns.length; i++){
        // curr=Math.max(curr, queryAns[i]);
        // if(queryAns[i]==0){
        // queryAns[i]=curr;
        // }
        // }
        // for(int i=0;i<queries.length; i++){
        // queries[i]=queryAns[queries[i]];
        // }

        return queries;
    }
}