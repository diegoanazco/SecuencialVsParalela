#include <iostream> 
#include <bits/stdc++.h>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <sys/time.h> 
#include <fstream>

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
	ofstream out("binary_search_secuencial_cpp.txt");
	for(int i = 0; i < 4; i++)
	{
		int n = pruebas[i];
		int arr[n];
		for(int j = 0; j < n; j++)
		{
			//arr[j] = rand() % n + 1;
			arr[j] = j;
		}
		
	
		sort(arr, arr+n); 
		static clock_t start = clock();
        //int x = rand() % n + 1; 
        
        int x = n - 1;
        int result = binarySearch(arr, 0, n - 1, x); 


		clock_t end = clock();		
		std::cout << "It took me " << (1000.00 * double(end-start))/double(CLOCKS_PER_SEC) << " seconds."<< "\n";
		out<<n<<"\t"<<(1000.00 * double(end-start))/double(CLOCKS_PER_SEC)<<"\n";
	}
	
	
	return 0; 
} 

