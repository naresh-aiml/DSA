class Solution {
    static class Pair implements Comparable<Pair> {
        int node, time;
        Pair(int n, int t){ node=n; time=t; }
        public int compareTo(Pair p2){ return this.time - p2.time; }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] e : times) graph.get(e[0]).add(new Pair(e[1], e[2]));
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.time > dist[curr.node]) continue;
            for(Pair nei : graph.get(curr.node)){
                if(dist[curr.node] + nei.time < dist[nei.node]){
                    dist[nei.node] = dist[curr.node] + nei.time;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}