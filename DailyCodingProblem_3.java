/***
This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

*/

class dailycodingproblem3
{
    public static int minimum(int x, int y, int z) {
        return Integer.min(x, Integer.min(y, z));
    }
    public static int distance(String A, int s, String B, int k)
    {
        if (s == 0) {
            return k;
        }
        if (k == 0) {
            return s;
        }
        int cost = (A.charAt(s - 1) == B.charAt(k - 1)) ? 0: 1;
 
        return minimum(distance(A, s - 1, B, k) + 1,    
                distance(A, s, B, k - 1) + 1,           
                distance(A, s - 1, B, k - 1) + cost);   
    }
    public static void main(String[] args)
    {
        String A = "kitten", B = "sitting";
 
        System.out.println("distance is " +
                distance(A, A.length(), B, B.length()));
    }
}
