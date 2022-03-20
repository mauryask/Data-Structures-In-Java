/*
* T(n) : O(no of words * max word length)
* S(n) : O(no of words * max word length)
** Very important datastructure
*/

import static java.lang.System.*;
import java.util.*;

class TrieNode 
{
	// word-end = 1, indicates the end of a word
	int we = 0; 
	TrieNode chArr[] = new TrieNode[26];
}

public class TrieImplementation 
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
		}
		
		root.we += 1;		
	}	
	
	// T(n) : O(word-length)
	static boolean searchWord(TrieNode root, String word)
	{
		char arrChar[] = word.toCharArray();
        
		for(char ch : arrChar)
		{
		   if(root.chArr[ch-'a'] != null)
			   root = root.chArr[ch-'a'];
		   else
			  return false;
		}
		
		return (root.we>0);
	}
	
	// T(n) : O(word-length)
	static void deleteWord(TrieNode root, String word)
	{
		char[] arrChar = word.toCharArray();
		boolean isPresent = true;
		
		for(char ch : arrChar)
		{
			if(root.chArr[ch-'a'] != null)
			   root = root.chArr[ch-'a'];
		    else
			{
				isPresent = false;
				break;
			}	
		}
		
		if(isPresent && root.we > 0)
		{
			root.we--;
			out.println("Word deleted successfully!");
		}
		else		
			out.println("Word is not found!");
	}
	
	public static void main(String [] args)
	{
		TrieNode root = new TrieNode();
		
		insertWord(root, "abc");
		insertWord(root, "abd");
		insertWord(root, "abb");
		insertWord(root, "abd");
		insertWord(root, "bcd");
		insertWord(root, "cde");
		
		out.println(searchWord(root, "abd"));
		//out.println(searchWord(root, "bca"));
		//out.println(searchWord(root, "abcd"));
		
		/*deleteWord(root, "abc");
		deleteWord(root, "ab");
		out.println(searchWord(root, "ab"));*/
	}
}