
public class reverseWords {
	
	public reverseWords()
	{
	}
	
	
	public String reverse(String s)
	{
        String reversed = "";
		String[] parsed = s.split(" ");
		
		if(parsed.length == 0)
		{
		    return "";
		}
		
		
		for(int i = parsed.length-1 ; i> -1; i--)
		{
			if(parsed[i].compareTo("") != 0) //if not null
			{
				reversed = reversed.concat(parsed[i]);
				if(i!= 0)
				{		
						reversed = reversed.concat(" ");
				}
			}
		}

		// trim reversed from space at the beginning and at the end
		if(reversed.length() !=0)
		{
			if(reversed.charAt(reversed.length()-1) == ' ')
			{
				reversed = reversed.substring(0, reversed.length()-1);
			}
			
			if(reversed.charAt(0) == ' ')
			{
				reversed = reversed.substring(1, reversed.length()-1);
			}
		}
		
		
		return reversed;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseWords reversed = new reverseWords();
		System.out.println("'" + reversed.reverse("sky is blue yeaaahhhh")  + "'");
				
		String s = reversed.reverse(" ");
		System.out.println("'" + s  + "'");

		
		
	}

}
