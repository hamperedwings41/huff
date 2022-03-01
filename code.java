import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	public class code {
	
	Node root; 
	
	PriorityQueue<Node> queue = new PriorityQueue<Node>();
	String bob;
	Scanner in;
	
	public code () throws FileNotFoundException
	{
		root = null;
		Scanner in = new Scanner( new File("tiny.txt"));
		bob = in.next();
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		code c = new code();
		
		c.count();
		
		for(Node n : c.getCount()) {
			System.out.println(n.data);
		}
		
	}
	
	public void count() {
		if(root != null)
			count(root);
	}
	
	private void count(Node t)
	{
		int m = 0;
		String[] arr = bob.split("");
		for(int x = 0; x<arr.length;x++)
		{
			char r=arr[x].charAt(0);
			if(!queue.contains(t.data))
			{
				m = 1;
				queue.add(new Node (r, m, null, null));	
			}
			else if(queue.contains(t.data))
			{
				m = t.cnt;
				queue.remove(t.data);
				queue.add(new Node (r, m++, null, null));	
			}
		}
		System.out.println(queue);

	}
	
	public PriorityQueue<Node> getCount(){
		return queue;
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
