class Solution {
    public void dfs(int[][] image, int r, int c, int color, int orig){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length){
            return;
        }
        if(image[r][c]!=orig){
            return;
        }
        image[r][c]=color;
        dfs(image,r+1,c,color,orig);
        dfs(image,r-1,c,color,orig);
        dfs(image,r,c+1,color,orig);
        dfs(image,r,c-1,color,orig);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}