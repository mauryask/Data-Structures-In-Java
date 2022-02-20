import static java.lang.System.*;
import java.util.*;

class TrieNode 
{
	// word-length
	int we = 0;
	char ch=  '0';	
	TrieNode chArr[] = new TrieNode[26];
}

public class AutoCompleteFeature
{	
   // T(n) : O(word-length)
	static void  insertWord(TrieNode root, String word)
	{
		char [] arrChar = word.toCharArray();
		
		for(char ch : arrChar)
		{			
			if(root.chArr[ch-'a'] == null)
			{
				TrieNode temp = new TrieNode();
				temp.ch = ch;
				root.chArr[ch-'a'] = temp;
				root = temp;
			}
		    else
              root = root.chArr[ch-'a'];		  
		}
        
      root.we += 1;		
	}	
	
	static void printSuggestions(TrieNode root, String word)
	{
		char [] arrChar = word.toCharArray();
		
		for(char ch : arrChar)
		{
			if(root.chArr[ch-'a'] != null)
               root = root.chArr[ch-'a'];
		    else 
				// here you cann insrt the rest of the part
				{
					out.println(word);
					return;
				} 
		}
				
				//out.println(root.chArr[3].we > 0);
		suggestUtil(root, new StringBuilder(word));
	}
	
	// restrict to top 3 suggestions
	static int suggestionCount = 0;
	
	static void suggestUtil(TrieNode root, StringBuilder  word)
	{
		if(root.we > 0)
		{
			out.println(word.toString());
			suggestionCount++;
		}
			
		if(suggestionCount == 2)
			return;
			
		for(int i=0; i<26; i++)
		{
			if(root.chArr[i] != null)
			{		
                TrieNode temp = root.chArr[i];		
				word.append(temp.ch);
                
				if(suggestionCount == 2)
                  return;				  
				
				suggestUtil(temp, word);
                word.deleteCharAt(word.length()-1);			
			}
		}
	}
		
	public static void main(String [] args)
	{
		TrieNode root = new TrieNode();
		
		insertWord(root, "abc");
		insertWord(root, "abd");
		insertWord(root, "abb");
		insertWord(root, "abd");
		insertWord(root, "abdcde");
		insertWord(root, "bcd");
		insertWord(root, "cde");

		printSuggestions(root, "a");
	}
}