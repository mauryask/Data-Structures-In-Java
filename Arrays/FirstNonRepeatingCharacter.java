/*
*https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
*/

import java.util.*;
import static java.lang.System.*;

public class FirstNonRepeatingCharacter 
{
	static String getFirstNonRepeatingCharacter(String A)
    {
       int[] ch = new int[26];
       Set<Character> set = new LinkedHashSet<>();
       StringBuilder rslt = new StringBuilder("");
       
      for(int i=0; i<A.length(); i++)
      {
          char c = A.charAt(i);
          int index = c - 97;
          ch[index]++;
          
          if(ch[index] == 1)
          {
                set.add(c);
              
              Iterator<Character> iter = set.iterator();
 
              if (iter != null && iter.hasNext())
                rslt.append(iter.next());
          }
          else if(ch[index] > 1)
          {
              set.remove(c);

              Iterator<Character> iter = set.iterator();
 
              if (iter != null && iter.hasNext())
                rslt.append(iter.next());
              else
                rslt.append("#");
          }
      }
             
      return  rslt.toString();  
    }
	
	public static void main(String [] args)
	{
		 String str = "abcdecf";
		 out.println(getFirstNonRepeatingCharacter(str));
	}
}