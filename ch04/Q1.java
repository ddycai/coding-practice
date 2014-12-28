/*
 * Given a binary tree, check if the tree is balanced.
 * A tree is balanced at r if |height(r.left) - height(r.right)| <= 1
 *
 * Explanation
 * Write a function isBalanced(r):
 * If r is a leaf, then it is balanced.
 * Otherwise, we recursively check if both the left and right subtrees of r are
 * balanced using the same algorithm.
 * If they are not, then this node is not balanced either.
 * If they are, then we check if the difference in height between the left and
 * right subtrees is <= 1. If so, then isBalanced returns true, else return
 * false.
 *
 * We also compute the height of each node along the way. If r is a leaf, then
 * r.height = 0. If r is not a leaf, then r.height = max(r.left.height ,
 * r.right.height).
 */
public class Q1 {

	public static boolean isBalanced(TreeNode r) {
		if(r.left == null && r.right == null) {
			r.height = 0;
			return true;
		}
		int lh = 0, rh = 0;

		if(r.left != null) {
			if(!isBalanced(r.left)) return false;
			lh = r.left.height + 1;
		}

		if(r.right != null) {
			if(!isBalanced(r.right)) return false;
			rh = r.right.height + 1;
		}

		r.height = Math.max(lh, rh);		
		if(Math.abs(lh - rh) <= 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		System.out.println(isBalanced(root));
	}
}

