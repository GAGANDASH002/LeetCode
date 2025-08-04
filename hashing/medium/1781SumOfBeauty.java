class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int[] sortedKeys = new int[map.size()];
        int index = 0;
        for(int key: map.keySet()){
            sortedKeys[index++] = key;
        }
        Arrays.sort(sortedKeys);

        for(int key: sortedKeys){
            if(map.get(key) > 0){
                int startCount = map.get(key);
                for(int i = key; i < key + groupSize; i++){
                    if(map.getOrDefault(i, 0) < startCount){
                        return false;
                    }
                    map.put(i, map.get(i) - startCount);
                }
            }
        }

        return true;
    }
}