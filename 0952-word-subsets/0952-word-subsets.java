class Solution {

    private List<int[]> wordsFreq(String[] words) {
        List<int[]> listArr = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int arr[] = new int[26];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }
            listArr.add(arr);
        }
        return listArr;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        // forming a common word

        int freq[] = new int[26];
        StringBuilder sb = new StringBuilder();
        for (String str : words2) {
            int[] tempFreq = new int[26];
            for (char c : str.toCharArray()) {
                tempFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.max(freq[i], tempFreq[i]);
            }
        }
        List<int[]> freqWords1 = wordsFreq(words1);

        int idx = 0;
        for (int[] currArr : freqWords1) {
            boolean isValid = true;
            for (int j = 0; j < 26; j++) {
                if (freq[j] > currArr[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(words1[idx]);
            }
            idx++;
        }
        return result;
    }
}