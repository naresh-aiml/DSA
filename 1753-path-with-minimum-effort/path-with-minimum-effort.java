class Solution {
    static class Pair implements Comparable<Pair> {
        int row, col, effort;
        Pair(int r, int c, int e){ row=r; col=c; effort=e; }
        public int compareTo(Pair p2){ return this.effort - p2.effort; }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.row==n-1 && curr.col==m-1) return curr.effort;
            for(int[] d : dir){
                int nr = curr.row+d[0], nc = curr.col+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newEffort = Math.max(curr.effort, Math.abs(heights[curr.row][curr.col]-heights[nr][nc]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Pair(nr,nc,newEffort));
                    }
                }
            }
        }
        return 0;
    }
}