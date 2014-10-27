/**
 * Lowest common ancestor of BST
 * 
 * @author ardyadipta
 *
 */
public class LowestCommonAncestor {
	//helper class for BST node
	public class Node
	{
		Node parent;
		Node left;
		Node right;
		int data;
		
		Node(int val)
		{
			data = val;
			parent = null;
			left = null;
			right = null;
		}
		
	}
	
	Node root;
	
	public LowestCommonAncestor()
	{
		root = null;
	}
	
	public void insertNode(Node treeNode, int val)
	{
		if(this.root == null){this.root = new Node(val);}
		else
		{
				if( val < treeNode.data)
				{
					if(treeNode.left !=null){insertNode(treeNode.left, val);}
					else{treeNode.left = new Node(val);}
				}
				else
				{
					if(treeNode.right != null){insertNode(treeNode.right, val);}
					else{treeNode.right = new Node(val);}
				}			
		}
	}
	
	public void insertNode(int val)
	{
		insertNode(this.root, val);
	}
	
	// class of find LCA
	// assume that a and b is in the tree
	public int findLCA(Node treeRoot , int a, int b)
	{
		if(treeRoot == null){return -1;}
		Node current = treeRoot;
		if(current.data < a && current.data < b)
		{
			return findLCA(current.right, a,b);
		}
		else if(current.data>a && current.data >b)
		{
			return findLCA(current.left, a, b);
		}
		
		return current.data;
	}
	
	public void PreOrder(Node current)
	{
		if(current == null){return;}
		System.out.println(current.data);
		if(current.left != null)
		{
			PreOrder(current.left);
		}
		if(current.right != null)
		{
			PreOrder(current.right);
		}
		
	}
	
	public void PreOrder()
	{
		PreOrder(this.root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.insertNode(20);
		tree.insertNode(8);
		tree.insertNode(22);
		tree.insertNode(4);
		tree.insertNode(12);
		tree.insertNode(10);
		tree.insertNode(14);
		
		tree.PreOrder();
		
		int a = 22;
		int b = 4;
		System.out.println("Lowest Common Ancestor for node " + a + " and " + b + " is: " + tree.findLCA(tree.root, a, b));
		
		

	}

}
