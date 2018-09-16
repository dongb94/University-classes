package ¼÷Á¦5;

public class ManyIf {
	public static void main(String [] args){
		int a = 0, b = 1, c = 1; double x = 1.5, y = 2.5, z = 1.0; boolean m = false;
		if (a > b)
		{
			b++;
			if (b > c)
				c++;
			if (y == x)
				y++;
			else z ++;
			if (!m)
			{
				System.out.println("XXXXXXXXXXXXXXXX ");
				System.out.println(a + b);
				System.out.println(y + a);
			}
			else
			{
				System.out.println("............................... ");
				System.out.println(a + b);
				System.out.println(x + y);
			}
		}
		else
		{
			a = b + c;
			if (x != 0)
				x = y + z;
			if (a != c)
				c = c - 1;
			else
				c = c + 1;
			if (c == 5)
				System.out.println("Same as it ever was " + a);
			else if (c == 6)
				System.out.println("Same as it ever was " + b);
			else if (c == 7)
				System.out.println("Same as it ever was " + c);
			else
				System.out.println("Same as it ever was " + x);
		}
	}
}
