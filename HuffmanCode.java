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
	
	public static void main(String[] args)
	{
		HuffmanCode c = new HuffmanCode();
		Queue<HuffmanNode> y = new PriorityQueue<HuffmanNode>();
		y = c.getFreq( "aba ab cabbb" );
		for (int i = 0; i < 4; i++)	// i don't know how to print queues bruh
			System.out.println( y.poll() );
	}
	
}
