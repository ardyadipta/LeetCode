/**
 * Find if a binary tree is symmetric or not
 * Leetcode: https://oj.leetcode.com/problems/symmetric-tree/
 * @author ardyadipta
 *
 */

 
public class isSymmetric{
	 // Definition for binary tree
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public boolean Solution(TreeNode root) {
        if(root == null){return true;}
        else
        {
            return helper(root.left, root.right);
        }
        
        
    }
    
    public boolean helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) // both of them null
        {
            return true;
        }
        if((left == null && right != null)||(left!= null && right == null)) // one of them is null
        {
            return false;
        }

        if(left.val == right.val)
        {
            return (helper(left.right, right.left) && helper(left.left, right.right));
        }
        else
        {
            return false;
        }
    }
}