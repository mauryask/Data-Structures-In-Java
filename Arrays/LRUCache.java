/*
* T(n) : O(n)
* S(n) : O(n)
***************
*LRU Cache 
****
* Principle locality of reference
*******
* Recently reffered page is more 
* likely to be reffered again
* very soon
*******
** If page is not present in the cache 
******** check if cahce is full
**** If yes remove the last page from cache 
**** add the new page in the front of the cache
**** If no add the page to the front of the cache
******** Check if page is present in the cache 
***** Remove it from its current position 
***** add it at the front of the cache
*/
import static java.lang.System.*;
import java.util.*;

public class LRUCache
{	
    static void referPage(int pages[], int cacheSize)
	{
		Deque<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		int pageFault  = 0;
		
		for(int x : pages)
		{
			/*
			* Check if page is not present
			*/
			if(!set.contains(x))
			{
				/*
				* Check if cache is full
				*/
				if(set.size() == cacheSize)
				{
					/*
					* Remove last page to make space for
					* newly arrived page
					*/
					int page =  q.removeLast();
					set.remove(page);
				}
				/*
				* Add new page at the front of the cache
				*/
				q.addFirst(x);
				set.add(x);
				/*
				* If page is not present it is page fault
				*/
				pageFault++;
			}
			/*
			* If page is present in the queue
			*/
			else
			{
				/*
				* remove it from its current location
				* add it at the front
				*/
				 q.remove(x);
				 q.addFirst(x);
			}
		}
		
		out.println(pageFault);
	}
   
	public static void main(String [] args)
	{
		int pages[] = {1,2,3,1,4,5};
		int cacheSize = 4;
	    referPage(pages, cacheSize);
	}
}