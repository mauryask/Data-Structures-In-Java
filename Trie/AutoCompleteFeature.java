import static java.lang.System.*;
import java.util.*;

public class AutoCompleteFeature
{	
	static class Node 
	{
		int we;
		Node[] arr= new Node[26];
	}
	
	static void createTrie(Node root, String word)
	{
		for(int i=0; i<word.length(); i++)
		{
			char ch = word.charAt(i);
			
			if(root.arr[ch-'a'] ==  null)
			{
				Node node = new Node();
				root.arr[ch-'a'] = node;
				root = node;
			}
			else
			{
				root = root.arr[ch-'a'];
			}
		}
		
		root.we++;
	}
	
    static void printSuggestion(String prefix, Node root)
	{		
		for(int i=0; i<prefix.length(); i++)
		{
			char ch = prefix.charAt(i);
			
			if(root.arr[ch-'a'] == null)
				return;
			else
			{
				root = root.arr[ch-'a'];
			}
		}
		
		suggestUtil(root, new StringBuilder(prefix));
	}
	
	static int sugestionCount = 0;
	
	static void suggestUtil(Node root, StringBuilder word)
	{
		if(root.we > 0)
		{
			out.println(word);
			sugestionCount++;
		}
		
		if(sugestionCount == 2)
			return;
		
		for(int i=0; i<26; i++)
		{
		   	if(root.arr[i] != null && sugestionCount < 2)
			{
				word.append((char)(i+'a'));
				suggestUtil(root.arr[i], word);
				word.deleteCharAt(word.length()-1);
			}
		}		
	}
	
    public static void main(String [] args)
	{		
	    Node root = new Node();
	    createTrie(root, "abc");
	    createTrie(root, "abd");
	    createTrie(root, "abfd");
	    createTrie(root, "agtr");
		String prefix = "a";
		printSuggestion(prefix, root);
	} 
}