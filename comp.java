package bobby;

import java.util.ArrayList;
import java.util.Collections;

public class comp {
	public static void main(String[] args)
	{
		String t = "256 365 12 96 1111 9999 284 980";
		String[] nums = t.split(" ");
		ArrayList<num> list = new ArrayList<num>();
		for( String v : nums)
			 list.add(new num(v) );
		Collections.sort(list );
		System.out.println(list);
	}
	
	 static class num implements Comparable<num>
	{
		String a;
		int d = 0;
		int y = 0;
		public num (String v )
		{
			a = v;
		}
		public int compareTo( num other)
		{
			int b = Integer.parseInt(a);
			int c = Integer.parseInt(other.a);
			
			while (b!= 0)
			{
				d = d + b % 10;
				b = b/10;
			}
			while(c!= 0)
			{
				y = y + c % 10;
				c = c/10;
			}
				if( d > y )
					return 1;
				if(d < y)
					return -1;
				if( d == y && b > c)
					return 1;
				return -1;
		}
		public String toString()
		{
			return a;
		}
	}
}

