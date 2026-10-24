class Solution {
    class Pair implements Comparable<Pair>{
        int node, cost;
        Pair(int n, int c){ node=n; cost=c; }
        public int compareTo(Pair p2){ return this.cost - p2.cost; }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(vis[curr.node]) continue;

            vis[curr.node] = true;
            finalCost += curr.cost;

            for(int i=0; i<n; i++){
                if(!vis[i]){
                    int dist = Math.abs(points[curr.node][0]-points[i][0]) + 
                               Math.abs(points[curr.node][1]-points[i][1]);
                    pq.add(new Pair(i, dist));
                }
            }
        }
        return finalCost;
    }
}