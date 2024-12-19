import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a map to store distances and their corresponding points
        Map<int[], Integer> map = new HashMap<>();

        // Compute the distance for each point and store it in the map
        for (int[] pt : points) {
            int dist = pt[0] * pt[0] + pt[1] * pt[1];
            map.put(pt, dist);
        }

        // Create a priority queue (min-heap) to sort points based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // Add all points to the priority queue
        for (int[] key : map.keySet()) {
            pq.add(key);
        }

        // Retrieve the k closest points
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
