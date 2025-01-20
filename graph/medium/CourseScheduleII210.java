/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Indegree array and map to store neighbours
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Computer neighbours of each node in the HashMap 
        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        
        // Compute indegree of each node
        for (int key : adj.keySet()) {
            for (int node : adj.get(key)) {
                inDegree[node]++;
            }
        }
        
        // Add vertex with 0 indegree into the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        // Topological Sort
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            if (adj.containsKey(node)) {
                for (int ngbr : adj.get(node)) {
                    inDegree[ngbr]--;
                    if (inDegree[ngbr] == 0) {
                        q.offer(ngbr);
                    }
                }
            }
        }
        
        Collections.reverse(ans);
        if (ans.size() == numCourses) {
            return ans.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}