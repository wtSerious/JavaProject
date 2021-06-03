package Algorithm.NearestRoad;

public class Dijkstra {
    static int vis[];
    static int dis[];
    static int[][] map;
    static int inf;
    public static void main(String[] args) {
        int source_position = 0;
        for (int i=0;i<vis.length;i++){
            int min=inf;
            int temp = 0;
            for (int j=0;j<vis.length;j++){
                if (vis[j]!=1&&dis[j]<min){
                    min = dis[j];
                    temp = j;
                }
            }
            vis[temp] = 1;
            for (int k = 0;k<vis.length;k++){
                if (vis[k]!=1){
                    if (dis[k]>dis[temp]+map[temp][k]){
                        dis[k] = dis[temp] + map[temp][k];
                    }
                }
            }
        }
    }
}
