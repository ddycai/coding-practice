/*
 * You are given a binary tree in which each node contains a value.
 * Design an algorithm to print all path which sum to a given value. That path does not need to start or end at the root or a leaf.
 *
 * Solution: Each node can branch off into multiple paths downwards, but can only branch up to one path (the ancestor path).
 * Therefore, for each node, construct a path upwards and along the way check if the sum of the path is equal to target.
 * If so, print that path.
 */

public class Q9 {

  public static void findPaths(TreeNode node, int target, int[] path, int depth) {
    if(node == null)
      return;

    // Add this node to the path
    int sum = 0;
    path[depth] = node.element;

    for(int i = depth; i >= 0; i--) {
      sum += path[i];
      if(sum == target) {
        for(int j = i; j <= depth; j++) {
          System.out.print(path[j] + " " );
        }
        System.out.println();
      }
    }

    // Search the left and right children
    findPaths(node.left(), target, path, depth + 1);
    findPaths(node.right(), target, path, depth + 1);

  }

  public static void main(String[] args) {
    TreeNode[] nodes = TreeNode.readTree();
    int[] path = new int[nodes.length];
    findPaths(nodes[0], 9, path, 0);
  }

    

}
