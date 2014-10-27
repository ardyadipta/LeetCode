
 
public class sortList {


//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	  public ListNode Solution(ListNode head) {
		        // this method assume that we modify the existing list, not create a new one
		        // the idea is, divide the list into half until it cannot be divided anymore, and then merge them recursively
		        if(head == null || head.next == null){return head;}
		        ListNode endOfFirstHalf = getHalf(head);
		        ListNode secondHalf = endOfFirstHalf.next;
		        
		        //then cut in the middle
		        endOfFirstHalf.next = null;
		        
		        //merge first half and second half
		        ListNode a = Solution(head);
		        ListNode b = Solution(secondHalf);
		        
		        return merge(a,b);
		    }
		    
		    public ListNode getHalf(ListNode head)
		    {
		        ListNode slow = head;
		        ListNode prev = head;
		        ListNode fast = head;
		        
		        while(fast != null && fast.next != null)
		        {
		            prev = slow;
		            slow = slow.next;
		            fast = fast.next.next;
		        }
		        
		        //start of the second half is slow
		        //prev is the end of the first half
		        return prev;
		    }
		    
		    public ListNode merge(ListNode a, ListNode b)
		    {
		        if(a == null){return b;}
		        if(b == null){return a;}
		        
		        //create a dummy node as the previous of the new merged node
		        ListNode dummy = new ListNode(0);
		        
		        //create a walker node named current
		        ListNode current = dummy;
		        
		        //begin to walk until both a and b are null
		        while(a != null && b != null)
		        {
		            if(a.val < b.val)
		            {
		                current.next = a;
		                current = current.next;
		                a = a.next;
		            }
		            else
		            {
		                current.next = b;
		                current = current.next;
		                b = b.next;
		            }
		        }
		        
		        if(a ==null)
		        {
		            current.next = b;
		        }
		        else
		        {
		            current.next = a;
		        }
		        
		        return dummy.next;
		        
		        
		    }
}