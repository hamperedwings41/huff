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
	
	
	
	private String getBinary(char x) {
		if(root == null)
			return "";
		return getBinary("", root, x);
	}
	
	private String getBinary(String r, HuffmanNode n, char x) {
		System.out.println(r + "	| " + n.cha + " | " + n.freq + " | " + x);
		
		if(n == null)
			return "";
		if(!n.isLeaf()) {
			return getBinary(r + "0", n.left, x) + getBinary(r + "1", n.right, x); 
		}
		if(n.isLeaf() && n.cha == x)
			return r;
		return "";	
	}
	
	public String encode(String x) {
		String str = "";
		
		for(char c : x.toCharArray()) {
			str += getBinary(c);
		}
		
		return str;
	}
	
	public String decode(String bin) {
		String r = "";                                                                                                                                                                                                                                ;
		HuffmanNode temp = root;
		
		for(int i = 0; i < bin.length(); i++) {
			if(bin.substring(i,i+1).equals("0"))
				temp = temp.left;
			if(bin.substring(i,i+1).equals("1"))
				temp = temp.right;
			
			if(temp.isLeaf()) {
				r += temp.cha;
				temp = root;
			}
		}
		
		return r == "" ? "Nothing" : r;
	}
	
	public static void main(String[] args)
	{
		String code = "aba ab cabbb";
		HuffmanCode c = new HuffmanCode();
		Queue<HuffmanNode> y = new PriorityQueue<HuffmanNode>();
		y = c.getFreq( code );
		HuffmanNode root = c.tree(y);
		
		System.out.println("\nBinary of a: " + c.getBinary('a'));
		System.out.println("\nBinary of b: " + c.getBinary('b'));
		
		String enc = c.encode(code);
		System.out.println("enc: " + enc);
		System.out.println(c.decode(enc));
		
	}
	
}
