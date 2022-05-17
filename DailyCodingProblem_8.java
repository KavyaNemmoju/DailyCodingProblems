/**
The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/








import java .io.*;

public class dailycodingproblem8 {
	static void generatePowerSet(char []set,int size)
	{
		long powset_size =(long)Math.pow(2, size);
		int split, n;
		for(split = 0; split < powset_size; split++)
		{
			for(n = 0; n < size; n++)
			{
				if((split & (1 << n)) > 0)
				System.out.print(set[n]);
			}
			
			System.out.println();
		}
	}
	public static void main (String[] args)
	{
		char []set = {'1', '2', '3'};
		generatePowerSet(set, 3);
	}
}
