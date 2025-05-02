class Pair{
    int stops,node,dist;
    public Pair(int s, int n, int d)
    {
        this.stops =s;
        this.node = n;
        this.dist = d;
    }
}
class Tuple{
    int node, dist;
    public Tuple(int node,int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list for each node storing adjacent edges with cost/distance
        List<List<Tuple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] flight:flights)
        adj.get(flight[0]).add(new Tuple(flight[1],flight[2]));

        // array to store cost of traversing each node from src
        int[] jour = new int[n];
        Arrays.fill(jour,Integer.MAX_VALUE);
        jour[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,src,0));

        // Finding minimum distance to reach goal node
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int stops = curr.stops, node = curr.node,dist = curr.dist;
            for(Tuple edge:adj.get(node))
            {
                int v = edge.node, w = edge.dist;
                if(stops>k) break;
                if(jour[v] > dist + w)
                {
                    jour[v] = dist + w;
                    q.offer(new Pair(stops+1,v,jour[v]));
                }
            }
        }
        return jour[dst] == Integer.MAX_VALUE ? -1 : jour[dst];
    }
}