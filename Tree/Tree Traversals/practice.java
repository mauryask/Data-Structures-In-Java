						
						
						
						index  	  1	  2   3   4
						A =       4   5	  2	 25
						            
						// O(n^2)
									
						for i=1 to n
						 if i=n
						    print(A[i] --> -1)
						 	break
						  for j = i+1 to n 
							if A[j] > A[i]
							   print(A[i] --> A[j])
							   break
						  end loop	 
					    end loop