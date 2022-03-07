import java.util.*;

public class HuffmanNode implements Comparable<HuffmanNode>
{
	char cha;
	int freq;
	HuffmanNode left;
	HuffmanNode right;
	String s;
	
	public HuffmanNode( char c, int f, HuffmanNode l, HuffmanNode r )
	{
		cha = c;
		freq = f;
		left = l;
		right = r;
		s = Character.toString(cha);
	}
	public HuffmanNode( int f, HuffmanNode l, HuffmanNode r )
	{
		cha = 0;
		freq = f;
		left = l;
		right = r;
		s = Character.toString(cha);
	}
	public HuffmanNode()
	{
		cha = 0;
		freq = 0;
		left = null;
		right = null;
		s = Character.toString(cha);
	}
	
	public int compareTo( HuffmanNode other )
	{
		if( freq > other.freq )
			return 1;
		if( freq < other.freq )
			return -1;
		return s.compareTo( other.s );
	}
	
	public String toString()	// prints out in preOrder format (D, L, R)
	{
		if(cha == 0)
			return "(" + freq + ") " + left + " " + right;
		else
			return "('" + cha + "' " + freq + ") " + left + " " + right;
	}
	
}
