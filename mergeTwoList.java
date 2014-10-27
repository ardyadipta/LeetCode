

 
public class mergeTwoList {
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	 }
	  
    public ListNode Solution(ListNode l1, ListNode l2) {
        // if one of them is null, return the other list
        if(l1 == null){return l2;} 
        if(l2 == null){return l1;}
        
        // the idea is, make a walker node, which is 'current'
        // the walker will walk to each node, starting with the list which has a lesser value than the other node
        // then everytime it walks, it will check the 'other' node value
        ListNode current;
        
        // the new list
        ListNode merged;
        
        ListNode mergedHead; // to point out the head of the new list
        ListNode other; // to point to the other list while walking
        
        if(l1.val < l2.val)
        {
            current = l1;
            other = l2;
        }
        else
        {
            current = l2;
            other = l1;
        }
        
        merged = new ListNode(current.val);
        mergedHead = merged;
        
        // while both of them are not null
        while(current != null || other != null)
        {
            current = current.next; // walk to the next node
            if(current == null && other == null){break;} // if both of them null, break the while
            
            // if the walker met null while the other is not null, switch
            // if the walker node has a higher value than the other node, switch
            if((current == null) || ((other !=null)&&(current.val > other.val)))
            {
                ListNode temp = current;
                current = other;
                other = temp;
            }
            
            // merge the node
            merged.next = new ListNode(current.val);
            
            // don't forget that merged list also has to come to the next node
            merged = merged.next;
        }
        // return the head of the new list
        return mergedHead;
        
    }
}