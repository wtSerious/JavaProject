package Algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @                           _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *           *                     佛祖保佑        永无BUG
 **/
//在给定的网格中，每个单元格可以有以下三个值之一：
//
//        值代表空单元格；
//        值代表新鲜橘子；
//        值代表腐烂的橘子。
//        每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
//
//        返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
//https://leetcode-cn.com/problems/rotting-oranges/
public class Solution {
    public static void main(String[] args) {
        int[][] grid={{2,1,1}};
        int result = orangesRotting(grid);
        System.out.println(result);

    }

    public static int orangesRotting(int[][] grid) {
        int[] vector_r = {1,-1,0,0};
        int[] vector_c = {0,0,1,-1};

        Queue<Integer> queue = new ArrayDeque<>();
        int n = grid[0].length;
        int count = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2)
                    queue.add(i*n+j);
                else if(grid[i][j]==1)
                    count++;
            }
        }
        int depth = 0;
        while (count>0&&!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int  i=0;i<size;i++){
                int node = queue.remove();
                for (int j=0;j<4;j++){
                    int r = node/n + vector_r[j];
                    int c = node%n + vector_c[j];
                    if (r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]==1){
                        grid[r][c]=2;
                        queue.add(r*n+c);
                        count--;
                    }
                }
            }
        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j< grid[i].length;j++){
                if (grid[i][j]==1)
                    return -1;
            }
        }

        return depth;
    }


}
