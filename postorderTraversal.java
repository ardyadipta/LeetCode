import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class postorderTraversal {
	
	
	// Definition for binary tree
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public List<Integer> Solution(TreeNode root) {
	    Stack<TreeNode> TreeStack = new Stack();
	    TreeNode current = root;
	    TreeNode popped;
	    List<Integer> postOrderList= new ArrayList<Integer>();
    	TreeStack.push(current);
    	
	    while(!TreeStack.isEmpty() && root != null)
	    {
	    	popped = TreeStack.pop();
	    	postOrderList.add(popped.val);
	    	if(popped.left != null){TreeStack.push(popped.left);}
	    	if(popped.right != null){TreeStack.push(popped.right);}
	    }
	    // now reverse the postOrderList
	    
        Collections.reverse(postOrderList);
	    return postOrderList;
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
