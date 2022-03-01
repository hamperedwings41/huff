import java.util.*;

public class HuffmanCode {
	
	HuffmanNode root;
	Queue<HuffmanNode> queue;
	Scanner in;
	String bob;
	
	public HuffmanCode()
	{
		root = null;
		queue = new PriorityQueue<HuffmanNode>();
		in = new Scanner(System.in);
		bob = in.next();
	}
	
	public void getFreq( String s )
	{
		int count[] = new int[256];
		int len = s.length();
		
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
				queue.add(new HuffmanNode(s.charAt(i), count[s.charAt(i)], null, null));
        }
		
	}
	
}
