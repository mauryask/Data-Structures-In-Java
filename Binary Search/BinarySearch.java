//here you need to sort the element any sorting technique
import static java.lang.System.*;

public class BinarySearch 
{
		static int binary_search(int A[], int target)
		{
			int m_index, l_index, r_index;
			m_index=0;
			l_index = 0;
			r_index = A.length-1;
			
			while(l_index <= r_index)
			{
				m_index = l_index + (r_index-l_index)/2;
				if(target == A[m_index])
				  return m_index;
				else if(target > A[m_index])
					l_index = m_index+1;
				else 
					r_index = m_index-1;	
			}

			return -1;
		}
		
		public static void main(String [] args)
		{
			int A[] = new int []{1,2,3,4,5,6,7,8,9}; 
			int target = 6;
		    int index=BinarySearch.binary_search(A, target);
		    out.println("The element is found at index: "+index);
		}

}
