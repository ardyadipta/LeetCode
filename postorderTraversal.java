import java.util.ArrayList;
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
	    List<Integer> reversedPostOrderList= new ArrayList<Integer>();
	    if(root == null){return postOrderList;}
    	TreeStack.push(current);
    	
	    while(TreeStack.isEmpty() == false)
	    {
	    	popped = TreeStack.pop();
	    	reversedPostOrderList.add(popped.val);
	    	if(popped.left != null){TreeStack.push(popped.left);}
	    	if(popped.right != null){TreeStack.push(popped.right);}
	    }
	    // now reverse the postOrderList
	    
	    for(int i = 0; i<reversedPostOrderList.size(); i++)
	    {
	    	postOrderList.add(reversedPostOrderList.get(reversedPostOrderList.size() - 1 -i));
	    }
	    
	    return postOrderList;
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
