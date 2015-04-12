import java.util.*;

/*
 * Given a sorted array of integers, write an algorithm to build a binary search tree of minimal height.
 *
 * Explanation
 * In order to have a binary search tree of minimal height, the left and right
 * subtrees must be balanced. How do we ensure that it is balanced? By picking
 * the root to be the middle element of the sorted array. This ensures that the
 * left and right subtrees have the same or almost the same number of nodes. We
 * then apply this recursively to the left and right subarrays.
 */
public class Q3 {

	public static TreeNode buildTree(int[] arr, int lo, int hi) {
		int mid = (lo + hi)/2;
		TreeNode t = new TreeNode(arr[mid]);

		if(lo > hi)
			return null;
		if(lo == hi)
			return t;

		t.setLeft(buildTree(arr, lo, mid - 1));
		t.setRight(buildTree(arr, mid + 1, hi));
		return t;
	}

  /**
   * I'm using this method to verify that the resulting tree is correct.
   */
	public static void inorder(TreeNode r) {
		if(r == null)
			return;
		inorder(r.left());
		System.out.println(r.element);
		inorder(r.right());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		TreeNode t = buildTree(arr, 0, arr.length - 1);
		inorder(t);

	}
}
