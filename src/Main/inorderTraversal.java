//package Main;
//
//public class inorderTraversal {
//    public static void main(String[] args) {
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root==null)
//            return this.result;
//        inorderSolution(root);
//        return this.result;
//    }
//
//    void inorderSolution(TreeNode root){
//        if(root==null)
//            return;
//        inorderSolution(root.left);
//        this.result.add(root.val);
//        inorderTraversal(root.right);
//        return;
//    }
//
//    public List<Integer> inorderTraversal_stack(TreeNode root) {
//        if(root==null)
//            return this.result;
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        TreeNode node = root;
//        while(!stack.isEmpty()||node!=null){
//            while(node!=null){
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            this.result.add(node.val);
//            node = node.right;
//        }
//        return this.result;
//    }
//
//
//}
