class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Build a mapping from index to position in sources/targets
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            String src = sources[i];
            if (idx + src.length() <= n && s.substring(idx, idx + src.length()).equals(src)) {
                indexMap.put(idx, i);
            }
        }

        int i = 0;
        while (i < n) {
            if (indexMap.containsKey(i)) {
                int k = indexMap.get(i);
                res.append(targets[k]);
                i += sources[k].length(); // Skip the length of the source string
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
    }
}
