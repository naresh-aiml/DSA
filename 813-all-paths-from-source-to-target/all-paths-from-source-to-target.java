class Solution {
    public void dfs(int[][] graph, int curr, int tar, List<Integer> path, List<List<Integer>> ans) {
        if(curr == tar) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int nei : graph[curr]) {
            path.add(nei);
            dfs(graph, nei, tar, path, ans);
            path.remove(path.size()-1); // backtrack
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, graph.length-1, path, ans);
        return ans;
    }
}