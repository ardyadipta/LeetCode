// make a copy of a list with random arbitrary pointer for each node.
// each node has a second pointer other than next pointer, pointing to any node in the list or null
// the idea is, we insert a new node with the same value of the old node, and then starting from there, we can
// make the same random pointer by pointing at the next of that randomly pointed node

public class copyRandomList {

	class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
		 };
		 
	public RandomListNode Solution(RandomListNode head) {
        // the idea is, we insert a new node between two nodes of the input
        if(head == null){return null;}
        RandomListNode current = head;
        RandomListNode newList;
        
        while(current != null)
        {
            newList = new RandomListNode(current.label);
            newList.next = current.next;
            current.next = newList;
            current = newList.next;
            
        }
        
        
        // when current reaches null, fill in the random
        current = head;
        while(current != null)
        {
            if(current.random == null){current.next.random = null;}
            else
            {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        //finally, separate new list from the old list
        RandomListNode newHead = head.next;
        current = head;
        RandomListNode currentNew;
        currentNew = newHead;
        while(current!= null)
        {
            current.next = currentNew.next;
            current = current.next;
            if(current == null){break;}
            currentNew.next = current.next;
            currentNew = currentNew.next;
        }
        
        return newHead;
        
        
        
   
	}
}
