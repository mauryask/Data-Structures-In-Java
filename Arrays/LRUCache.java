// Implementation of LRU Cache
// Time Complexity  : O(n) 
// Space Complexity : O(n)
// "n" is number of of page requests

import static java.lang.System.*;
import java.util.*;

public class LRUCache
{	
	public static void main(String [] args)
	{
		// these are pages requetsed by 
		// processor
		
		int pages[] = {1,2,3,4,1,3};
		// size of cache
		int cache_size = 3;
	    lruCache(pages, cache_size);
	}
	
	static void lruCache(int pages[], int cache_size)
	{
		Deque<Integer> dq = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
	
     	int page_fault = 0;
		for(int i=0; i<pages.length; i++)
		{
			// if page is not present in the cache
			// it indicates "pagefault"
			
			if(!map.containsKey(pages[i]))
			{
			  // if cache is full remove the 
			  // least recently used page
			  if(dq.size() == cache_size)
				  map.remove(dq.removeFirst());  
			  
			  // put new page into the cache
			  map.put(pages[i],1);
			  dq.add(pages[i]);
			  page_fault++;
			}
			else
			{
				// if page is already present in the cache
				// just simply remove it from its current position
				// and add it to the front of the queue
				
			  	dq.remove(pages[i]);
				dq.add(pages[i]);
			}
		}
		//printing total page faults
		out.println(page_fault);
	}
}