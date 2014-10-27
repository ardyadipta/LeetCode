import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

 
public class cloneGraph {
	 // Definition for undirected graph.
	  class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };
	  
    public UndirectedGraphNode Solution(UndirectedGraphNode node) {
        // thanks to jasontgi of leetcode,
        // the idea is using BFS to solve this problem, we will traverse the whole graph using this method
        // we use HashMap to store the newly created Node of the graph where we will eventually return this
        // and we use queue to store the remaining unexplored neighbors
        
        if(node == null){return null;}
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        // make a walker node, starting with the input node
        UndirectedGraphNode current = node ;
        int headLabel = node.label;
        
        // initialize the hash map by putting the first node
        map.put(headLabel, new UndirectedGraphNode(node.label));
        
        while(current != null)
        {
            UndirectedGraphNode newNode = map.get(current.label);
            //check each neighbor on the current node
            for (UndirectedGraphNode checkNeighbor: current.neighbors)
            {
                //if there is no node of that neighbor in the current map, then create it
                if(!map.containsKey(checkNeighbor.label))
                {
                    map.put(checkNeighbor.label, new UndirectedGraphNode(checkNeighbor.label));
                    // store that neighbor in the queue.
                    // using this method, we can keep the data of unexplored neighbors
                    // remember, this queue stores the actual node from the input, not the new ones that we just created
                    queue.add(checkNeighbor);
                }
                
                newNode.neighbors.add(map.get(checkNeighbor.label));
                
            }
            
            current = queue.poll();
            
            // 
        }
        
        return map.get(headLabel);
        
        
    }
}