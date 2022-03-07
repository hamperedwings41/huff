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
	
//	public HuffmanNode makeTree( Queue<HuffmanNode> q )
//	{
//		if( !q.isEmpty() )
//		{
//			HuffmanNode o = q.poll();
//			if( q.peek()==null )
//				return makeTree( o, 0 );
//			else
//				return makeTree( q.poll(), o, 0 );
//		}
//		else
//			return null;
//	}
//	private HuffmanNode makeTree( HuffmanNode r, int sum )
//	{
//		HuffmanNode c = new HuffmanNode(r.freq+sum, makeTree(r, r.freq+sum), r);
//		return r;
//		
//	}
//	private HuffmanNode makeTree( HuffmanNode l, HuffmanNode r, int sum )
//	{
//		HuffmanNode c = new HuffmanNode(r.freq+sum, makeTree(r, r.freq+sum), r);
//		return r;
//		
//	}
	
	public HuffmanNode makeTree(Queue<HuffmanNode> q)
	{
		while(q.size() > 1)
		{
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
	
	public static void main(String[] args)
	{
		HuffmanCode c = new HuffmanCode();
		Queue<HuffmanNode> y = new PriorityQueue<HuffmanNode>();
		y = c.getFreq( "aba ab cabbb" );
	//	for (int i = 0; i < 4; i++)	// i don't know how to print queues bruh
	//		System.out.println( y.poll() );
		System.out.println( c.makeTree( y ) );
	}
	
}
