import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
 
public class mergeKLists {
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  
    public ListNode Solution(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){return null;}
        
        //Ok, the idea is using PriorityQueue to solve this list
        //First, let's make a priorityqueue with modified Comparator to compare the value of the nodes inside the list
        
        Comparator<ListNode> newComparator = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2)
            {
                if(o1.val < o2.val){return -1;}
                if(o1.val == o2.val){return 0;}
                return 1;
            }
        };
        
        //now create a priorityQueue
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), newComparator);
        
        // for each node in the list, I would like to insert it to the queue
        for(ListNode node: lists)
        {
            if(node !=null)
            {
                queue.add(node);
            }
        }
        
        //then I will merge them here, starting from the head of the node
        // the idea is, I would like to use a dummy node as the beginning of the list so that eventually, 
        // I will return dummy.next
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        //now let's iterate each of the node inside of the queue
        while(!queue.isEmpty())
        {
            tail.next = queue.poll();
            tail = tail.next;
            
            // remember, our list is list of sorted Linked List, so we may have another nodes attached to each node in the queue
            // we would like to sort those with the other nodes inside the queue
            // in order to do that, we have to put them back inside the queue so that it can be compared to other nodes.
            if(tail.next !=null)
            {
                queue.add(tail.next);
            }
            
        }
        
        //finally, return the merged list
        return dummy.next;
    }
}