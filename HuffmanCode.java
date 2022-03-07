import java.util.*;

public class HuffmanCode {
	
	HuffmanNode root;
	Queue<HuffmanNode> queue;
	//Scanner in;
	
	public HuffmanCode()
	{
		root = null;
		queue = new PriorityQueue<HuffmanNode>();
		//in = new Scanner(System.in);
	}
	
	public Queue<HuffmanNode> getFreq( String s )
	{
		int count[] = new int[256];
		int len = s.length();
		Queue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
		
		for (int i = 0; i < len; i++)
			count[s.charAt(i)]++;
		char ch[] = new char[s.length()];
		for (int i = 0; i < len; i++)
		{
			ch[i] = s.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++)
			{
				if (s.charAt(i) == ch[j])
					find++;
			}
			
			if(find == 1)
				q.add(new HuffmanNode(s.charAt(i), count[s.charAt(i)], null, null));
        }
		
		return q;
	}
	
	public HuffmanNode tree(Queue<HuffmanNode> q) {
		while(q.size() > 1) {
			HuffmanNode l = null,r = null,big = new HuffmanNode();
			
			l = q.poll();
			r = q.poll();
			
			big.freq = l.freq + r.freq;
			
			big.left = l;
			big.right = r;
			
			big.cha = 0;
			
			root = big;
			
			q.add(big);
		}
		
		return root;
	}
	
	public void preorder() {
		preorder(root);
	}
	
	private void preorder(HuffmanNode n) {
		if(n != null) {
			
			preorder(n.left);
			System.out.print(n.freq + " ");
			preorder(n.right);
		}
	}
	
	public static void main(String[] args)
	{
		HuffmanCode c = new HuffmanCode();
		Queue<HuffmanNode> y = new PriorityQueue<HuffmanNode>();
		y = c.getFreq( "aba ab cabbb" );
		HuffmanNode root = c.tree(y);
		
		for (HuffmanNode n : y)	// i don't know how to print queues bruh
			System.out.println(n);
		
		c.preorder();
		
	}
	
}
