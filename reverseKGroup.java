
public class reverseKGroup {
	
	class ListNode
	{
		int val;
		ListNode next;
		
		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
	
	ListNode tail;
	
	public reverseKGroup()
	{
		this.tail = tail;
	}
	
	public ListNode reverseK(ListNode head, int k)
	{
		// first, I would like to cut the list into chunks based on k
        // each chunk has pre-node as its indicator
        // for the very first chunk, since it doesn have any prenode, I use a dummy node
        if( k<=1 || head ==null)
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preChunk = dummy;
        
        // next, I would like to make a node as an indicator of our step
        ListNode current = head;
        
        // I would like to make another node as a marker that the chunk has ended
        ListNode endChunk = current.next;
        ListNode reverseThis = current;
        
        //make a temp node to make sure that next chunk has k nodes
        ListNode temp;
        
        // reverse one node, and then shift it to the right
        // 1-2-3 --> 2-1-3 --> 3-2-1
        //begin checking each node
        while(current != null)
        {
            int n = 0;
            temp = preChunk;
            while(n <=k)
            {
                // mark endChunk
                if(temp != null)
                {
                    n++;
                    temp = temp.next;
                    
                }
                else
                {
                    return dummy.next;
                }
            }
            endChunk = temp;
        
            while(current.next != endChunk )
            {
                reverseThis = current.next;
                //reverse node
                current.next = reverseThis.next;
                reverseThis.next = preChunk.next;
                preChunk.next = reverseThis;
                
                
            }
            preChunk = current;
            current = preChunk.next;
            
        }
        return dummy.next;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
