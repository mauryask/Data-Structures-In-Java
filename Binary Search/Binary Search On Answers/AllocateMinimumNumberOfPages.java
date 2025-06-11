//T(n) : O(N * log(m-n)): N, =. Array size, m => sum, n => max pages in a book
import static java.lang.System.*;

public class AllocateMinimumNumberOfPages{
	static int getStudentCoutn(int[] A, int maxAllowedPages){
		int student = 1;//Start with first student
		long pagesAssigned = 0;//Pages assigned to current student
		
		for(int i=0; i<A.length; i++){
			//If it is not possiblke to allocate current book to any student at all
			if(A[i] > maxAllowedPages)
			  return Integer.MAX_VALUE;
		   //Keep assigning the pages to current student until the maxAllowed limit is reached
		    if(A[i] + pagesAssigned <= maxAllowedPages){
				pagesAssigned += A[i];
			}else{//If limit exceecds assign the current book to next student
				student++;
				pagesAssigned = A[i];
			}
		}
		
		return student;
	}
	
	static int allocateBooks(int[] A, int k){
		if(A.length < k)
			return -1;
		//Minimum possible value of maximum pages is the largest single book (Since each student must get at least one book)
		int start = 0; //max pages in the array
		//Maximum possible value is the sum of all the pages (If one student gets all the books)
		int end = 0;		
		int ans = 0;
		
		for(int x : A){
			start = Math.max(start, x);
			end += x;
		}
		
		while(start <= end){
			int mid = start + (end - start) / 2;
			//For each 'mid' (max-allowed-pages) check if it is possible to allocate books to 'k' students: Such that no student gets more than 'mid' pages
			int student = getStudentCoutn(A, mid);
			//If maxAllowedPages are more: Some students will be lft getting books
			if(student <= k){
				ans = mid;
				end = mid - 1;
			}else{//If maxAllowedPages are less: Some books will be left unallocated
				start = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] A = {25, 46, 28, 49, 24};
		int k = 4;
		int ans = allocateBooks(A, k);
		out.println(ans);
	}
}