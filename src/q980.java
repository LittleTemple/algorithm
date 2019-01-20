/**
 * Author:   amos
 * Date:     2019/1/20 10:06 PM
 * Description:
 */

public class q980 {
    static int res = 0,sx,sy,ex,ey,empty = 1;
    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0) empty++;
                else if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }else if(grid[i][j] == 2){
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(grid,sx,sy);
        return res;

    }

    static void dfs(int[][] grid,int x,int y){
        if(!check(grid,x,y)) return;
        if(x == ex && y == ey && empty == 0){
            res++;
            return;
        }

        grid[x][y] = -2;
        empty--;
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
        grid[x][y] = 0; //说实话，这个地方我还是没看懂。查了一下，主要使用的算法是回溯法。

    }
    static boolean check(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        return 0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 0;
    }

    public static void main(String[] args){
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        uniquePathsIII(grid);
    }

}