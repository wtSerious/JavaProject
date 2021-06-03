package Algorithm.UnionSet;

public class Base {
    public static int[] fa;

    public static void main(String[] args) {

    }

    public void init(){
        for (int i=0;i<fa.length;i++){
            fa[i] = i;
        }
    }

    public int find(int x){
        if (x ==fa[x])
            return x;
        return find(fa[x]);
    }

    public int fin2(int x){
        return x==fa[x]?x:(fa[x] = find(fa[x]));
    }


    public void unition(int x,int y){
        fa[find(x)] = find(y);
    }




}
