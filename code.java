import java.util.*;


	public class code {
	
	Node root; 
	
	Queue<String> count = new PriorityQueue<>();
	Scanner in;
	String bob;

	
	public code ()
	{
		root = null;
		in = new Scanner(System.in);
		bob = in.next();
	}
	
	public void count( String a, Node t)
	{
		int m = 1;
		String[] arr = bob.split("");
		for(int x = 0; x<arr.length;x++)
		{
			
			
			}
				
					
		
	}
	
	
	
	
	
	
	
	class Node
	{
		Comparable data;
		Node left;
		Node right;
		int cnt;

		public Node( Comparable v, int cnt, Node l, Node r)
		{
			data = v;
			left = l;
			right = r;
		}
		
		public String toString()
		{
			return "" + data + " " + left + " " + right;
		}
	}
}
