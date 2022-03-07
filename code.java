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
		System.out.println("check 1");
		System.out.println("check 2");
		c.count(null);
		for(Node n : c.getCount()) {
			System.out.println("check 3");
			System.out.println(n.data);
		}
		System.out.println("check 5");
		
	}
	
	
	
	public void count(Node t)
	{
		int m = 0;
		queue.add(new Node('a',1,null,null));
		String[] arr = bob.split("");
		for(int x = 0; x<arr.length;x++)
		{
			char r=arr[x].charAt(0);
			for(Node n : queue)
			{
				while(queue.peek()!=null)
				{
					if(queue.peek().data != r)
						{
						System.out.println("check");
							queue.add(new Node (r, 1, null, null));	
							
						}
					else if(queue.peek().data == r)
						{
							m = t.cnt;
							queue.remove(t.data);
							queue.add(new Node (r, m++, null, null));	
						}
				}
			}
		}
		System.out.println(queue);

	}
	
	public PriorityQueue<Node> getCount(){
		System.out.println("check 4");
		System.out.println(queue);
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