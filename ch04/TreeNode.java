/**
 * Simple class for TreeNode
 */

import java.util.Scanner;

public class TreeNode {
	private TreeNode left, right;
  private TreeNode parent;
	int element;
	int height;
	public TreeNode() {
		this(0);
	}
	public TreeNode(int n) {
		height = 0;
		left = right = null;
		element = n;
    parent = null;
	}

  public void setLeft(TreeNode n) {
    left = n;
    if(n != null)
      n.parent = this;
  }

  public void setRight(TreeNode n) {
    right = n;
    if(n != null)
      n.parent = this;
  }

  public TreeNode left() { return left; }
  public TreeNode right() { return right; }
  public TreeNode parent() { return parent; }

  public static TreeNode[] readTree() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    TreeNode[] nodes = new TreeNode[n];
    for(int i = 0; i < n; i++)
      nodes[i] = new TreeNode(i);

    for(int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if(nodes[a].left() == null)
        nodes[a].setLeft(nodes[b]);
      else if(nodes[a].right() == null)
        nodes[a].setRight(nodes[b]);
      else
          throw new RuntimeException("Invalid input...");
    }
    sc.close();
    return nodes;
  }

	public static int height(TreeNode r) {
		if(r.left == null && r.right == null) {
			r.height = 0;
		} else {
			int lh = 0, rh = 0;
			if(r.left != null) lh = r.left.height + 1;
			if(r.right != null) rh = r.right.height + 1;
			r.height = Math.max(lh, rh);
		}
		return r.height;
	}


  public static void inorder(TreeNode r) {
    if(r == null)
      return;
    inorder(r.left());
    System.out.println(r.element);
    inorder(r.right());
  }
}
