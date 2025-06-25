class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int currNum = 1;
        int i = 1;
        String arr[] = new String[n];
        List<String> li = new ArrayList<>();
        for(int j=1; j<=n; j++){
            li.add(Integer.toString(j));
        }
        Collections.sort(li);
        for(String item:li){
            list.add(Integer.parseInt(item));
        }
        // System.out.println(li);

        // while(i <= n){
        //     list.add(currNum);
        //     i++;
        //     int digit = (int)Math.floor(Math.log10(currNum))+1;
        //     int tens =  (int)Math.pow(10, digit);
        //     int leftNum = tens*currNum;
        //     int rightNum = (currNum+1)*tens;
        //     while(i <= n && leftNum <= n && leftNum < rightNum){
        //         list.add(leftNum);
        //         leftNum++;
        //         i++;
        //     }
        //     currNum++;
        // }
        // System.out.println(list);
        return list;
    }
}