/**A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.
*/




import java.util.*;
import java.lang.*;

public class DailyCodingProblem11 {
	public static int findnth(int m)
	{
		int count = 0;
		for (int curr = 1;; curr++) {
			int sum = 0;
			for (int n = curr; n > 0; n = n / 10)
				sum = sum + n % 10;
			if (sum == 10)
				count++;	
			if (count == m)
				return curr;
		}
	}

	public static void main(String[] args)
	{
		System.out.print(findnth(2));
	}
}



