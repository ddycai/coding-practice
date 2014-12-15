/**
 * Question: Find the first common ancestor of two nodes in a binary tree
 * Solution: Go up the ancestor path of the first node
 * For each ancestor, check if the second node is in the subtree
 */

import java.util.Scanner;

public class CommonAncestor {

  public static TreeNode firstCommonAncestor(TreeNode a, TreeNode b) {
    TreeNode current = a.parent();
    while(current != null) {
      if(searchTree(current.left(), b) || searchTree(current.right(), b))
        return current;
      current = current.parent();
    }
    return null;
  }

  public static boolean searchTree(TreeNode root, TreeNode find) {
    if(root == null)
      return false;
    if(root == find)
      return true;
    return searchTree(root.left(), find) || searchTree(root.right(), find);
  }

  public static void main(String[] args) {
    TreeNode[] nodes = TreeNode.readTree();
    //TreeNode.inorder(nodes[0]);
    TreeNode ans = firstCommonAncestor(nodes[9], nodes[7]);
    System.out.println(ans.element); 
  }

}
