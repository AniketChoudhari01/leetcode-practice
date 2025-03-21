class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // if to be made is in intial ingrediants is in supplies check in set
        Set<String> supply_set = new HashSet<>();// fast lookup available
        for (String supply : supplies) {
            supply_set.add(supply);
        }
        int n = recipes.length;
        List<String> ansList = new ArrayList<>();
        boolean added;
        do {
            added = false;
            for (int i = 0; i < n; i++) {
                if(supply_set.contains(recipes[i])) continue;

                boolean isMade = true;
                for (String ingrediant : ingredients.get(i)) {
                    if (!supply_set.contains(ingrediant)) {
                        isMade = false;
                        break;
                    }
                }
                if (isMade) {
                    supply_set.add(recipes[i]);
                    ansList.add(recipes[i]);
                    added = true;
                }
            }
        } while (added);

        return ansList;
    }
}