class Solution {
    private boolean findCycle(Map<Integer, ArrayList<Integer>> adjMap, int node, int parent, Set<Integer> visited, List<Integer> path){
        visited.add(node);
        path.add(node);
        List<Integer> currList = adjMap.get(node);
        for(int i=0; i<currList.size(); i++){
            int neighbor = currList.get(i);
            if(!visited.contains(neighbor)){
                if(findCycle(adjMap, neighbor, node, visited, path)){
                    return true;
                }
            }else if(neighbor != parent){
                path.add(neighbor);
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for(int i=1; i<=n; i++){
            adjMap.put(i, new ArrayList<Integer>());
        }
        for(int arr[]:edges){
            adjMap.get(arr[0]).add(arr[1]);
            adjMap.get(arr[1]).add(arr[0]);
        }
        System.out.println(adjMap);
        int startIdx = 0;
        Set<Integer> visited= new HashSet<>();
        List<Integer> path = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(!visited.contains(i)){
                if(findCycle(adjMap, i, -1, visited, path)){
                    startIdx = path.indexOf(path.get(path.size()-1));
                    // System.out.println("path : "+path.subList(startIdx, path.size()));
                    break;
                }
            }
        }
        HashSet<Integer> inCycle = new HashSet<Integer>();
        for(int i=startIdx ; i<path.size();i++){
            inCycle.add(path.get(i));
        }
        for(int i=n-1; i>=0 ; i--){
            if(inCycle.contains(edges[i][0]) && inCycle.contains(edges[i][1])){
                return new int[] {edges[i][0], edges[i][1]};
            }
        }
        
        return new int[]{};
    }
}