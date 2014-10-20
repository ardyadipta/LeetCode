
/**
 * To Check Whether a Linked List has loop in it.
 * The idea is, set two nodes with different speed of jumping to the next node.
 * Let's say, node A will go to 1 node ahead each time, and node B will go to 2 nodes ahead each time.
 * If there is a Loop in the list, at some time A and B will meet.
 * @author ardyadipta
 *
 */
public class LinkedListCycle {
	ListNode head;
	ListNode tail;
	
	private class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val =x;
			next = null;
		}
	}
	
	public LinkedListCycle()
	{
		this.head = null;
		this.tail = null;
		
	}
	
	public void addNode(int n)
	{
		if(this.head == null)
		{
			this.head = this.tail = new ListNode(n);
		}
		else
		{
			this.tail.next = new ListNode(n);
			this.tail = this.tail.next;		
		}
	}
	
	
	public boolean hasCycle(ListNode head)
	{
        if (head == null)
		{
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(slow != null & fast != null)
		{
			slow = slow.next; // slow node goes to the next node			
			if(fast.next == null) // in case next node of fast is null, do not need to check again. to prevent null pointer exception also
			{
			    return false;
			}
			
			fast = fast.next.next; // fast node goes to next 2 nodes ahead
			if(slow == fast)
			{
				return true;
			}
		}
		return false;
				
	}
	
	@Override
	public String toString()
	{
		String list = "";
		ListNode currentNode = this.head;
		int i = 0;
		while(currentNode != null & i != 6)
		{
			list = list.concat(Integer.toString(currentNode.val));
			list = list.concat("\n");
			currentNode = currentNode.next;
			i = i+1;
		}
		return list;
	}
	
	public void makeLoop()
	{
		this.tail.next = this.head.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycle list = new LinkedListCycle();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.makeLoop();
		
		if (list.hasCycle(list.head))
		{
			System.out.println("list has cycle");
		}
		
		System.out.println(list.toString());
		
		
	}

}
