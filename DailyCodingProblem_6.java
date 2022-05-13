/**
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

*/









import java.util.Arrays;
import java.util.List;
 
class dailycodingproblem6
{
    public static void wordbreak(List<String> dict, String word, String out)
    {
        if (word.length()==0)
        {
            System.out.println(out);
            return;
        }
 
        for (int n = 1; n <= word.length(); n++)
        {
            String prefix = word.substring(0, n);
            if (dict.contains(prefix)) {
                wordbreak(dict, word.substring(n), out + " " + prefix);
            }
        }
    }
    public static void main(String[] args)
    {
        List<String> dict = Arrays.asList( "bedbath", "and", "beyond");
        String word = "bedbathandbeyond";
        wordbreak(dict, word, "");
    }
}
