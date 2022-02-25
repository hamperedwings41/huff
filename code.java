import java.util.*;


public class code {
	
	Node root; 
	
	Scanner in;
	
	public code ()
	{
		root = null;
		in = new Scanner(System.in);
	}
	
	static void count( String a)
	{
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private class Node
	{
		Comparable data;
		Node left;
		Node right;

		public Node( Comparable v, Node l, Node r)
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
