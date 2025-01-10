class Solution {

    private List<int[]> wordsFreq(String[] words){
        List<int[]> listArr = new ArrayList<>();
        for(int i = 0 ;i<words.length; i++){
            String str = words[i];
            int arr[] = new int[26];
            for(int j = 0; j <str.length(); j++){
                arr[str.charAt(j)-'a']++;
            }
            listArr.add(arr);
        }
        return listArr;
    }
    private int[] maxFreqForEachChars(List<int[]> list){
        int maxi = 0;
        for(int i = 0; i<26; i++){
            for(int j = 0; j<list.size(); j++){
                maxi = Math.max(maxi, list.get(j)[i]);
            }
            list.get(0)[i] = maxi;
            maxi = 0;
        }
        return list.get(0);
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        //forming a common word
        List<int[]> listArr = wordsFreq(words2);
        int freq[] = maxFreqForEachChars(listArr);
        System.out.println("a:");
        System.out.println(Arrays.toString(freq));
       
        List<int[]> freqWords1 = wordsFreq(words1);
        // System.out.println("list");
        // for(int []arr: freqWords1){
        //     System.out.println(Arrays.toString(arr));
        // }
        int idx =0;
        for(int []currArr: freqWords1){
            boolean isValid = true;
            for(int j = 0; j<26; j++){
                if(freq[j] > currArr[j]){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                result.add(words1[idx]);
            }
            idx++;
        }
        //forming list arr for words1

        return result;
    }
}