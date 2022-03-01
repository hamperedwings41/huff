import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	public class code {
	
	Node root; 
	
	PriorityQueue<Node> count = new PriorityQueue<Node>();
	String bob;
	Scanner in = new Scanner(System.in);
	
	public code () throws FileNotFoundException
	{
		root = null;
		bob = in.next();
	    Scanner in = new Scanner( new File("tiny.txt"));
	}
	
	public void count( String a, Node t)
	{
		int m = 0;
		String[] arr = bob.split("");
		for(int x = 0; x<arr.length;x++)
		{
			char r=arr[x].charAt(0);
			if(!count.contains(t.data))
			{
				m = 1;
				count.add(new Node (r, m, null, null));	
			}
			else if(count.contains(t.data))
			{
				m = t.cnt;
				count.remove(t.data);
				count.add(new Node (r, m++, null, null));	
			}
		}
		System.out.println(count);

	}
	
	
	
	
	
	
	
	class Node
	{
		char data;
		Node left;
		Node right;
		int cnt;

		public Node( char v, int c, Node l, Node r)
		{
			data = v;
			left = l;
			right = r;
			cnt = c;
		}
		
		public String toString()
		{
			return "" + data + " " + left + " " + right;
		}
	}
}
