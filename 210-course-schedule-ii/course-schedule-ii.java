class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        
        int indeg[] = new int[numCourses];
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) if(indeg[i]==0) q.add(i);
        
        int ans[] = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans[idx++] = curr;
            for(int nei : graph.get(curr)) {
                indeg[nei]--;
                if(indeg[nei]==0) q.add(nei);
            }
        }
        if(idx != numCourses) return new int[0];
        return ans;
    }
}