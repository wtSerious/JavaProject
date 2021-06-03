package Algorithm.binaryTree;

import java.util.*;

// 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
//
// 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
//
// 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
//
// 注意：节点没有值，本问题中仅仅使用节点编号。
// 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
//        输出：true
// https://leetcode-cn.com/problems/validate-binary-tree-nodes/
//n = 4, leftChild = [3,-1,1,-1], rightChild = [-1,-1,0,-1]
//n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
public class Solution1 {
    public static Set<Integer> vis;
    public static int[] fa;

    public static void main(String[] args) {
        vis = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(", ");
        String str1 = strs[0].replace("n = ","");
        int n  = Integer.valueOf(str1);
        String str2 = strs[1].replace("leftChild = [","");
        str2 = str2.replace("]","");
        String[] str2s = str2.split(",");
        int[] leftChild = new int[str2s.length];
        for (int i=0;i<leftChild.length;i++){
            leftChild[i] = Integer.valueOf(str2s[i]);
        }

        String str3 = strs[2].replace("rightChild = [","");
        str3 = str3.replace("]","");
        String[] str3s = str3.split(",");
        int[] rightChild = new int[str3s.length];
        for (int i=0;i<rightChild.length;i++){
            rightChild[i] = Integer.valueOf(str3s[i]);
        }

        // 利用 dfs
//        boolean result = Solution(n,leftChild,rightChild);
        //利用并查集
        boolean result = Solution2(n,leftChild,rightChild);
        System.out.println(result);

    }

    public static boolean Solution(int n,int[] leftChild,int[] rightChild){
        int[] ru = new int[n];
        for (int i=0;i<n;i++){
            if (leftChild[i]!=-1){
                ru[leftChild[i]]++;
            }
            if (rightChild[i]!=-1)
                ru[rightChild[i]]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (ru[i]==0)
                list.add(i);
        }
        boolean flag = dfs(list.get(0),leftChild,rightChild);
//        boolean flag = true;
//        for (Integer integer:list){
//            flag = dfs(integer,leftChild,rightChild)&&flag;
//        }
        if (flag&&vis.size()==n)
            return true;
        return false;
    }

    public static boolean dfs(int root,int[] leftChild,int[] rightChild){
        if (root==-1)
            return true;
        if (vis.contains(root)){
            return false;
        }
        vis.add(root);
        return dfs(leftChild[root],leftChild,rightChild)&&dfs(rightChild[root],leftChild,rightChild);
    }

    // 并查集
    public static boolean Solution2(int n,int[] leftChild,int[] rightChild){
        fa = new int[n];
        init(fa);
        for (int i=0;i<n;i++){
            int l = leftChild[i];
            int r = rightChild[i];
            if (l!=-1){
                if (find(i)==find(l))
                    return false;
                if(find(l)!=l)
                    return false;
                union(i,l);
            }
            if(r!=-1){
                if (find(i)==find(r)){
                    return false;
                }
                if (find(r)!=r)
                    return false;
                union(i,r);
            }
        }
        int count = 0;
        for (int i=0;i<n;i++){
            if (fa[i]==i)
                count++;
        }
        return count==1;
    }

    public static void init(int[] fa){
        for (int i=0;i<fa.length;i++)
            fa[i] = i;
    }

    public static int find(int x){
        return x==fa[x]?x:(fa[x]=find(fa[x]));
    }

    public static void union(int x,int y){
        fa[find(y)] = find(x);
    }




}
