import static java.lang.System.*;
import java.util.*;

class TrieNode 
{
	// prefix-count 
	int pc = 0; 
	TrieNode chArr[]  = new TrieNode[26];
}

public class CountNumberOfStringsWithGivenPrefix
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
				root.chArr[ch-'a'] = temp;
				root = temp; 
			}
		    else
              root = root.chArr[ch-'a'];
		  
           root.pc++;		  
		}	
	}	
	
	// T(n) : O(prefix-length)
	static int countString(TrieNode root, String prefix)
	{
		char arrChar[] = prefix.toCharArray();
        
		for(char ch : arrChar)
		{
		   if(root.chArr[ch-'a'] != null)
			   root = root.chArr[ch-'a'];
		   else
			  return 0;
		}
				
		return root.pc;
	}
		
	public static void main(String [] args)
	{
		TrieNode root = new TrieNode();
		
		insertWord(root, "abc");
		insertWord(root, "bca");
		insertWord(root, "ab");
		insertWord(root, "fcda");
		insertWord(root, "pfet");
		insertWord(root, "flex");

		out.println(countString(root, "a"));
	}
}