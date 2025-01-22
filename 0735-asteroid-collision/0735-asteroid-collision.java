class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> posSt = new LinkedList<>();
        int n = asteroids.length;
        for(int i=0; i<n; i++){
            if(asteroids[i]>0){
                posSt.push(asteroids[i]);
                continue;
            }
            int abs = Math.abs(asteroids[i]);
            while(posSt.peekLast()!=null && posSt.peek()<abs){
                posSt.pop();
            }
            if(posSt.peekLast()!=null && (posSt.peek() == abs)){
                posSt.pop();//don't add anything;
            }else if(posSt.peekLast()==null){
                ans.add(asteroids[i]);//for negative dominating
            }
        }
        if(posSt.peekLast()!=null){
            ans.add(posSt.removeLast());
        }
        System.out.println(ans);
        int res[] = new int[ans.size()+posSt.size()];
        int i=0;
        while(!ans.isEmpty()){
            res[i++] = ans.remove(0);
        }
        while(posSt.peekLast()!=null){
            res[i++] = posSt.removeLast();
        }
        return res;
    }
}