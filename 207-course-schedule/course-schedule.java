class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Kahn's Algo
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        
        }
        int indeg[] = new int[numCourses];
        for(int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            graph.get(src).add(dest);
            indeg[dest]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) if(indeg[i]==0) q.add(i);
        
        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();
            count++;
            for(int nei : graph.get(curr)) {
                indeg[nei]--;
                if(indeg[nei]==0) q.add(nei);
            }
        }
        return count == numCourses;
    }
}