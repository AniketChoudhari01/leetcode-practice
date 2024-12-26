import java.util.HashMap;
import java.util.Map;

class Solution {
    private int dfs(int idx, int sum, int target, int[] nums, Map<String, Integer> memo) {
        // Base case
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        // Create a unique key for the current state
        String key = idx + "," + sum;

        // Check if the result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive case: Try adding and subtracting the current number
        int add = dfs(idx + 1, sum + nums[idx], target, nums, memo);
        int subtract = dfs(idx + 1, sum - nums[idx], target, nums, memo);

        // Store the result in memo
        memo.put(key, add + subtract);

        return memo.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, target, nums, memo);
    }
}
