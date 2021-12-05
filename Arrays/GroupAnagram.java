import static java.lang.System.*;
import java.util.*;

public class GroupAnagram
{
	// Best solution
	// T(n) : O(mn)
	// S(n) : O(mn)
    static void groupAnagrams(String[] strs)
    {
      Map<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();    
     
        for(String str : strs) // O(n)
        {
            HashMap<Character, Integer> fmap = new HashMap<>();
            
            for(int i=0; i<str.length(); i++) // O(m)
            {
                char c = str.charAt(i);
                fmap.put(c, fmap.getOrDefault(c, 0)+1);
            }
            
            if(bmap.containsKey(fmap))
                bmap.get(fmap).add(str);
            else
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(fmap, list);
            }
        }
        
        for(ArrayList<String> strList: bmap.values())
            out.println(strList);
    }
 
    public static void main(String [] args)
    {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
		
        groupAnagrams(strs);
    }
}