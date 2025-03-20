/*
 * There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.

 

Example 1:

Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]

Output: [1,-1]

Explanation:


To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).

In the second query, there is no walk between nodes 3 and 4, so the answer is -1.

Example 2:

Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]]

Output: [0]

Explanation:


To achieve the cost of 0 in the first query, we need to move on the following edges: 1->2 (weight 1), 2->1 (weight 6), 1->2 (weight 1).

 
*/




public class Solution {

    // DFS to assign a component id to each node and compute the global AND of edge weights in that component.
    private static void dfs(int node, List<List<int[]>> adj, boolean[] visited, int[] comp, int cid, int[] compAnd) {
        visited[node] = true;
        comp[node] = cid;
        // Process all adjacent edges
        for (int[] edge : adj.get(node)) {
            int neighbor = edge[0];
            int weight = edge[1];
            // For the first encountered edge in this component, compAnd[cid] will be -1.
            // In that case, assign weight; otherwise, update via bitwise AND.
            if (compAnd[cid] == -1) {
                compAnd[cid] = weight;
            } else {
                compAnd[cid] &= weight;
            }
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, comp, cid, compAnd);
            }
        }
    }
    
    // Main method to answer queries.
    // n: number of vertices, edges: each edge is [u, v, w], queries: each query is [s, t]
    public static int[] minimumCost(int n, int[][] edges, int[][] queries) {
        // Build an undirected graph (adjacency list)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // edge format: [u, v, w]
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        boolean[] visited = new boolean[n];
        int[] comp = new int[n]; // component id for each vertex
        // We'll store the global AND for each component.
        // Initialize each component's AND as -1 (meaning "unset").
        int[] compAnd = new int[n];
        Arrays.fill(compAnd, -1);
        
        int cid = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, comp, cid, compAnd);
                cid++;
            }
        }
        
        // Answer queries: if two nodes are in the same component, answer is that component's AND; else -1.
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int t = queries[i][1];
            if (comp[s] == comp[t]) {
                // If the component has no edges, compAnd will be -1; in that case, define the cost as 0.
                result[i] = (compAnd[comp[s]] == -1 ? 0 : compAnd[comp[s]]);
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
    
    
}
