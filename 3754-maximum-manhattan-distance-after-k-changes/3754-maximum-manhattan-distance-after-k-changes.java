class Solution {
    public int maxDistance(String s, int k) {
        // HashSet<Character> set = new HashSet<>();
        int maxi = 0;
        List<HashSet<Character>> list = new ArrayList<>();
        list.add(0, new HashSet<>(Set.of('N', 'E')));
        list.add(1, new HashSet<>(Set.of('N', 'W')));
        list.add(2, new HashSet<>(Set.of('S', 'E')));
        list.add(3, new HashSet<>(Set.of('S', 'W')));

        for (HashSet<Character> set : list) {
            int temp = k;
            int x = 0, y = 0;
            for (char ch : s.toCharArray()) {
                if (!set.contains(ch) && temp-- > 0) {
                    if (ch == 'N') {
                        y -= 1;
                    } else if (ch == 'S') {
                        y += 1;
                    } else if (ch == 'E') {
                        x -= 1;
                    } else {
                        x += 1;
                    }
                } else {
                    if (ch == 'N') {
                        y += 1;
                    } else if (ch == 'S') {
                        y -= 1;
                    } else if (ch == 'E') {
                        x += 1;
                    } else {
                        x -= 1;
                    }
                }
                // System.out.println(x+" , "+y);
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
            }
            System.out.println();
        }
        return maxi;

        /* int arr[] = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'A']++;
        }
        for (char ch : s.toCharArray()) {
            if (ch == 'S' && arr['N' - 'A'] > arr[ch - 'A'] && k-- > 0) {
                y += 1;
                // System.out.println(x + " ," + y);
                // System.out.println(set);

                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'N' && arr['S' - 'A'] > arr[ch - 'A'] && k-- > 0) {
                y -= 1;
                // System.out.println(x + " ," + y);
                // System.out.println(set);

                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'E' && arr['W' - 'A'] > arr[ch - 'A'] && k-- > 0) {
                x -= 1;
                // System.out.println(x + " ," + y);
                // System.out.println(set);
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'W' && arr['E' - 'A'] > arr[ch - 'A'] && k-- > 0) {
                x += 1;
                // System.out.println(x + " ," + y);
                // System.out.println(set);
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));

                continue;
            }

            if (ch == 'S' && set.contains('N') && k-- > 0) {
                y += 1;
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'N' && set.contains('S') && k-- > 0) {
                y -= 1;
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'E' && set.contains('W') && k-- > 0) {
                x -= 1;
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }
            if (ch == 'W' && set.contains('E') && k-- > 0) {
                x += 1;
                maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
                continue;
            }

            if (ch == 'S') {
                y -= 1;
            }
            if (ch == 'N') {
                y += 1;
            }
            if (ch == 'E') {
                x += 1;
            }
            if (ch == 'W') {
                x -= 1;
            }
            set.add(ch);
            // System.out.println(x + " ," + y);
            // System.out.println(set);
            maxi = Math.max(maxi, Math.abs(x) + Math.abs(y));
        }
        return maxi; */
    }
}