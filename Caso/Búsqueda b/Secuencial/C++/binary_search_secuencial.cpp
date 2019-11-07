#include <iostream> 
#include <bits/stdc++.h>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <sys/time.h> 

using namespace std; 


int binarySearch(int arr[], int l, int r, int x) 
{ 
	while (l <= r) { 
		int m = l + (r - l) / 2; 

		if (arr[m] == x) 
			return m; 

		if (arr[m] < x) 
			l = m + 1; 

		else
			r = m - 1; 
	}  
	return -1; 
} 

int main(void) 
{ 
	srand (time(NULL));

	int pruebas[] = {1000, 5000, 10000, 15000};
		
	for(int i = 0; i < 4; i++)
	{
		int n = pruebas[i];
		int arr[n];
		for(int j = 0; j < n; j++)
		{
			arr[j] = rand() % n + 1;
		}
		
	
		sort(arr, arr+n); 
        int x = rand() % n + 1; 
        
        struct timeval start, end; 
  
 
 	   gettimeofday(&start, NULL); 
  
    
    	ios_base::sync_with_stdio(false); 
        int result = binarySearch(arr, 0, n - 1, x); 
        gettimeofday(&end, NULL); 

		double time_taken; 
		  
	    time_taken = (end.tv_sec - start.tv_sec) * 1e6; 
	    time_taken = (time_taken + (end.tv_usec - start.tv_usec)) * 1e-6; 
        
        cout << "Time taken by program is : " << fixed << time_taken << setprecision(6); 
        cout << " sec" << endl; 
	}
	
	
	return 0; 
} 

