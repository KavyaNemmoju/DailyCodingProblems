
//Count Occurrences using Hashmap






  import java.util.HashMap;
  public class Dailycodingproblem
{ 
 public static void main(String[] args)
    {
       characterCount("Meditation is Good");
 
       characterCount("very Hungry");
 
       characterCount("USA has 50 states");
    }
 
 static void characterCount(String inputString)
    {
        HashMap<Character, Integer> eachCharCountMap = new HashMap<Character, Integer>();
        char[] charArray = inputString.toCharArray();
        for (char c : charArray)
        {
            if(eachCharCountMap.containsKey(c))
            {
                eachCharCountMap.put(c, eachCharCountMap.get(c)+1);
            }
            else
            {
 
                eachCharCountMap.put(c, 1);
            }
        }
        System.out.println(eachCharCountMap);
    }
}
