import java.util.*;

public class HuffmanNode implements Comparable<HuffmanNode>
{
	char cha;
	int freq;
	HuffmanNode left;
	HuffmanNode right;
	String s;
	
	public HuffmanNode( char c, int f, HuffmanNode l, HuffmanNode r)
	{
		cha = c;
		freq = f;
		left = l;
		right = r;
		s = Character.toString(cha);
	}
	public HuffmanNode( int f, HuffmanNode l, HuffmanNode r)
	{
		cha = (Character) null;
		freq = f;
		left = l;
		right = r;
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
		return "('" + cha + "' " + freq + ") " + left + " " + right;
	}
	
}
