/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
https://oj.leetcode.com/problems/trapping-rain-water/
 * @author ardyadipta
 *
 */
public class waterTrapped {
	
	    public int trap(int[] A) {
	        // the idea is, whe walk the array from the left and the right
	        // whenever exist a left boundary>0 and right boundary>0 and they differ,
	        // there must be water trapped between them if they are separated by a distance
	        int leftMax = 0;
	        int rightMax = 0;
	        int l = 0; //left iterator
	        int r = A.length -1; // right iterator
	        int trapped = 0; // water trapped
	        
	        //we iterate them from both side until they meet
	        while(l<=r)
	        {
	            leftMax = Math.max(leftMax, A[l]);
	            rightMax = Math.max(rightMax, A[r]);
	            if(leftMax < rightMax)
	            {
	                trapped += leftMax - A[l];
	                l++;
	            }
	            else
	            {
	                trapped += rightMax - A[r];
	                r--;
	            }
	            
	        }
	        return trapped;
	        
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
