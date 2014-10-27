import java.util.Comparator;
import java.util.PriorityQueue;


public class samplePriorityQueue {
	



	public static void main(String[] args) {
		
		class Node
		{
			int data;
			Node next;
			public Node(int val)
			{
				data = val;
			}
			
		}
		
		Comparator<Node> newComparator = new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2)
			{
				if(o1.data < o2.data){return -1;}
				if(o1.data == o2.data){return 0;}
				return 1;
			}
		};
		
		PriorityQueue<Node> lists = new PriorityQueue<Node>(5, newComparator);
		lists.add(new Node(5));
		lists.add(new Node(10));
		lists.add(new Node(3));
		lists.add(new Node(2));
		lists.add(new Node(15));
		lists.add(new Node(8));
		lists.add(new Node(7));
		lists.add(new Node(3));
		
		while(!lists.isEmpty())
		{
			System.out.println(lists.poll().data);
		}
		
		
		
		

	}

}
