package SwordToOffer.Easy.offer27;

/**
 * Create by LiShuang on 2020/11/24 19:55
 **/

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode node=new TreeNode(0);
            node=root.left;
            root.left=root.right;
            root.right=node;
        return root;
    }
}
